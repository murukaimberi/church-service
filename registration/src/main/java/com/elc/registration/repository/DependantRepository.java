package com.elc.registration.repository;

import com.elc.registration.entity.Dependant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DependantRepository extends JpaRepository<Dependant, Long> {
    List<Dependant> findByUserId(Long userId);
}
