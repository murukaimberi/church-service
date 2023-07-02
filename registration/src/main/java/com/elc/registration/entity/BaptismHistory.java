package com.elc.registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "baptism_histories")
public class BaptismHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "parish_name", nullable = false)
    private String parishName;
    @NotNull
    @Column(name = "baptism_date", nullable = false)
    private LocalDate baptismDate;
    @NotNull
    @Column(name = "confirmed_date", nullable = false)
    private LocalDate confirmedDate;
    @NotNull
    @Column(name = "parish_baptised_at", nullable = false)
    private String parishBaptisedAt;
    @NotNull
    @Column(name = "parish_confirmed_at", nullable = false)
    private String parishConfirmedAt;
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;
}
