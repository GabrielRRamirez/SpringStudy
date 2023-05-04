package com.ramirez.springstudy.modules.doctor.usecase.dto;

import com.ramirez.springstudy.modules.doctor.domain.enums.specialty;

public record CreateDoctorDto(

        String name,
        String email,
        String telephone,
        String crm,
        specialty specialty,
        AddressDoctorDto address) {
}
