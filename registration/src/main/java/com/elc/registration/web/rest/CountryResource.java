package com.elc.registration.web.rest;

import com.elc.registration.entity.Country;
import com.elc.registration.repository.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/countries")
@AllArgsConstructor
@Slf4j
public class CountryResource {
    private final CountryRepository countryRepository;
    @GetMapping
    public ResponseEntity<List<Country>> getCountries(){
        return ResponseEntity.status(HttpStatus.OK).body(countryRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country){
        return ResponseEntity.status(HttpStatus.CREATED).body(countryRepository.save(country));
    }

    @PutMapping
    public ResponseEntity<Country> updateCountry(@RequestBody Country country){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryRepository.save(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id){
        countryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
