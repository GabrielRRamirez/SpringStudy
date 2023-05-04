package com.ramirez.springstudy.modules.doctor.usecase.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateDoctorDto(

        @NotNull
        long id,
        String name,
        String telephone,
        AddressDoctorDto address) {
}
