package com.elc.registration.web.rest;

import com.elc.registration.entity.BaptismHistory;
import com.elc.registration.repository.BaptismHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/baptism-histories")
@AllArgsConstructor
@Slf4j
public class BaptismHistoryResource {
    private final BaptismHistoryRepository baptismHistoryRepository;

    @PostMapping
    public ResponseEntity<BaptismHistory> createBaptismHistory(@RequestBody BaptismHistory baptismHistory){
        return ResponseEntity.status(HttpStatus.CREATED).body(baptismHistoryRepository.save(baptismHistory));
    }

    @PutMapping
    public ResponseEntity<BaptismHistory> updateBaptismHistory(@RequestBody BaptismHistory baptismHistory){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(baptismHistoryRepository.save(baptismHistory));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BaptismHistory> findBaptismHistoryByUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(baptismHistoryRepository.findByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBaptismHistory(@PathVariable Long id){
        baptismHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
