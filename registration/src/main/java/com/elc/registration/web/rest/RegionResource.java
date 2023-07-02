package com.elc.registration.web.rest;

import com.elc.registration.entity.Region;
import com.elc.registration.repository.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/regions")
@AllArgsConstructor
@Slf4j
public class RegionResource {
    private final RegionRepository regionRepository;
    @GetMapping
    public ResponseEntity<List<Region>> getRegions(){
        return ResponseEntity.status(HttpStatus.OK).body(regionRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region){
        return ResponseEntity.status(HttpStatus.CREATED).body(regionRepository.save(region));
    }

    @PutMapping
    public ResponseEntity<Region> updateRegion(@RequestBody Region region){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(regionRepository.save(region));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id){
        regionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
