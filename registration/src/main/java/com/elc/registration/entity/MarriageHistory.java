package com.elc.registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "marriage_histories")
public class MarriageHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "marriage_date", nullable = false)
    private LocalDate marriageDate;
    @NotNull
    @Column(name = "parish_marriage_at", nullable = false)
    private String parishMarriedAt;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;
}
