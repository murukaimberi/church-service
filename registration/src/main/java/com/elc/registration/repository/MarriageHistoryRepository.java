package com.elc.registration.repository;

import com.elc.registration.entity.MarriageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarriageHistoryRepository extends JpaRepository<MarriageHistory, Long> {
    List<MarriageHistory> findByUserId(Long userId);
}
