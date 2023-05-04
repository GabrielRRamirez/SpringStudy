package com.ramirez.springstudy.modules.doctor.usecase.dto;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;

public record FindDoctorDto(Long id, String name, String email, String crm, com.ramirez.springstudy.modules.doctor.domain.enums.specialty specialty) {

    public FindDoctorDto(Doctor medicoEntity) {
        this(medicoEntity.getId(), medicoEntity.getName(), medicoEntity.getEmail(), medicoEntity.getCrm(), medicoEntity.getSpecialty());
    }
}
