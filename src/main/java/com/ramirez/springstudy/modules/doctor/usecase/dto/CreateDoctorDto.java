package com.ramirez.springstudy.modules.doctor.usecase.dto;

import com.ramirez.springstudy.modules.doctor.domain.enums.Specialty;

public record CreateDoctorDto(

        String name,
        String email,
        String telephone,
        String crm,
        Specialty specialty,
        AddressDoctorDto address) {
}
