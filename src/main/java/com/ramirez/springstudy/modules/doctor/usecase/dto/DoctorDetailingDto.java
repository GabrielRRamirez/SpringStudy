package com.ramirez.springstudy.modules.doctor.usecase.dto;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.doctor.domain.enums.Specialty;

public record DoctorDetailingDto(
        Long id,
        String name,
        String email,
        String telephone,
        String crm,
        Specialty specialty,
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
