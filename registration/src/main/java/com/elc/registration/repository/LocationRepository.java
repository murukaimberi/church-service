package com.elc.registration.repository;

import com.elc.registration.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByUserId(Long userId);
}
