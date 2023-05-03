package com.ramirez.springstudy.models.doctor;

import com.ramirez.springstudy.models.address.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record CreateDoctorDto(

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String telephone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        specialty specialty,

        @NotNull
        @Valid
        Address address) {
}
