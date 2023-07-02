package com.elc.authority.entity;

import com.elc.authority.entity.enumeration.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "congregants")
public class Congregant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;
    @NotNull
    @Column(name = "first_names", nullable = false)
    private String firstNames;
    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    @Column(name = "profession", nullable = false)
    private String profession;
    @ManyToMany
    @JoinTable(
            name = "congregant_authority",
            joinColumns = @JoinColumn(name = "congregant_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities;
}
