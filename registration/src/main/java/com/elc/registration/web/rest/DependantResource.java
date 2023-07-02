package com.elc.registration.web.rest;

import com.elc.registration.entity.Dependant;
import com.elc.registration.repository.DependantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1.0/dependants")
@Slf4j
public class DependantResource {
    private final DependantRepository dependantRepository;

    @GetMapping
    public ResponseEntity<Page<Dependant>> findAllDependents(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(dependantRepository.findAll(pageable));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Dependant>> findDependantsByUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(dependantRepository.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Dependant> createDependant(@RequestBody Dependant dependant){
        return ResponseEntity.status(HttpStatus.CREATED).body(dependantRepository.save(dependant));
    }

    @PutMapping
    public ResponseEntity<Dependant> updateDependant(@RequestBody Dependant dependant){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dependantRepository.save(dependant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDependant(@PathVariable Long id){
        dependantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
