package com.elc.authority.rest;

import com.elc.authority.entity.Authority;
import com.elc.authority.entity.Congregant;
import com.elc.authority.mapper.CongregantMapper;
import com.elc.authority.model.RegisterRequest;
import com.elc.authority.repository.AuthorityRepository;
import com.elc.authority.repository.CongregantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/congregants")
@RequiredArgsConstructor
public class CongregantResource {
    private final CongregantMapper congregantMapper;
    private final CongregantRepository congregantRepository;
    private final AuthorityRepository authorityRepository;
    @PostMapping("/register")
    public ResponseEntity<Congregant> register(@RequestBody RegisterRequest registerRequest){
        Congregant congregant = congregantMapper.toCongregant(registerRequest);
        Authority authority = authorityRepository.save(Authority.builder().name("ROLE_USER").build());
        congregant.getAuthorities().add(authority);
        Congregant savedCongregant = congregantRepository.save(congregant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCongregant);
    }
}
