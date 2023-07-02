package com.elc.registration.web.rest;

import com.elc.registration.entity.Location;
import com.elc.registration.repository.LocationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/locations")
@AllArgsConstructor
@Slf4j
public class LocationResource {
    private final LocationRepository locationRepository;
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        return ResponseEntity.status(HttpStatus.CREATED).body(locationRepository.save(location));
    }

    @PutMapping
    public ResponseEntity<Location> updateLocation(@RequestBody Location location){
        return ResponseEntity.status(HttpStatus.OK).body(locationRepository.save(location));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Location>> getLocationByUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(locationRepository.findAllByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id){
        locationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
