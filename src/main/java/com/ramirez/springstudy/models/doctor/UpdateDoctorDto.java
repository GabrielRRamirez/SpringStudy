package com.ramirez.springstudy.models.doctor;

import com.ramirez.springstudy.models.address.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateDoctorDto(

        @NotNull
        long id,

        String name,

        String telephone,

        @Valid
        Address address) {
}
