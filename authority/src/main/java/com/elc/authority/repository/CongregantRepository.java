package com.elc.authority.repository;

import com.elc.authority.entity.Congregant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongregantRepository extends JpaRepository<Congregant, Long> {
}
