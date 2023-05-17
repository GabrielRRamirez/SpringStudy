package com.ramirez.springstudy.modules.patient.usecase.dto;

import com.ramirez.springstudy.modules.doctor.usecase.dto.AddressDoctorDto;

public record UpdatePatientDto(Long id,
                               String name,
                               String telephone,
                               AddressDoctorDto address) {
}
