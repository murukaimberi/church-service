package com.elc.registration.repository;

import com.elc.registration.entity.BaptismHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaptismHistoryRepository extends JpaRepository<BaptismHistory, Long> {
    BaptismHistory findByUserId(Long userId);
}
