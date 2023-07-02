package com.elc.registration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "locations")
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "street_address", nullable = false)
    private String streetAddress;
    @NotNull
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @NotNull
    @Column(name = "city", nullable = false)
    private String city;
    @NotNull
    @Column(name = "state_province", nullable = false)
    private String stateProvince;
    @OneToOne
    private Country country;
    @NotNull
    @Column(name = "userId", nullable = false)
    private Long userId;
}
