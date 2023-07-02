package com.elc.authority.model;

import com.elc.authority.entity.enumeration.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    @NotNull
    private String title;
    @NotNull
    private String firstName;
    @NotNull
    private String secondNames;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;
    @NotNull
    private String profession;
}
