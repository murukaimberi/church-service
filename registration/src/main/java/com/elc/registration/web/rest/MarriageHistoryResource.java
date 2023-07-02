package com.elc.registration.web.rest;

import com.elc.registration.entity.MarriageHistory;
import com.elc.registration.repository.MarriageHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/marriage-histories")
@AllArgsConstructor
@Slf4j
public class MarriageHistoryResource {
    private final MarriageHistoryRepository marriageHistoryRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<List<MarriageHistory>> findMarriageHistoryByUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(marriageHistoryRepository.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<MarriageHistory> createMarriageHistory(@RequestBody MarriageHistory marriageHistory){
        return ResponseEntity.status(HttpStatus.CREATED).body(marriageHistoryRepository.save(marriageHistory));
    }

    @PutMapping
    public ResponseEntity<MarriageHistory> updateMarriageHistory(@RequestBody MarriageHistory marriageHistory){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(marriageHistoryRepository.save(marriageHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarriageHistory(@PathVariable Long id){
        marriageHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
