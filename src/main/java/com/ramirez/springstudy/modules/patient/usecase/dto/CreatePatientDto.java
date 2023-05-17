package com.ramirez.springstudy.modules.patient.usecase.dto;

import com.ramirez.springstudy.modules.doctor.usecase.dto.AddressDoctorDto;

public record CreatePatientDto(String name,
                               String email,
                               String telephone,
                               String cpf,
                               AddressDoctorDto address) {
}
