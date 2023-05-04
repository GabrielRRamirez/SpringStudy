package com.ramirez.springstudy.modules.doctor.usecase.dto;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;

public record DoctorDetailingDto(
        Long id,
        String name,
        String email,
        String telephone,
        String crm,
        com.ramirez.springstudy.modules.doctor.domain.enums.specialty specialty,
        AddressDoctorDto address) {

    public DoctorDetailingDto(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getTelephone(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                new AddressDoctorDto(doctor.getAddress()));
    }
}
