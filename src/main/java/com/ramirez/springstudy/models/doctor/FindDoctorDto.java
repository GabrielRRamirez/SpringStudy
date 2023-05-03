package com.ramirez.springstudy.models.doctor;

import com.ramirez.springstudy.entities.DoctorEntity;

public record FindDoctorDto(Long id, String name, String email, String crm, specialty specialty) {

    public FindDoctorDto(DoctorEntity medicoEntity) {
        this(medicoEntity.getId(), medicoEntity.getName(), medicoEntity.getEmail(), medicoEntity.getCrm(), medicoEntity.getSpecialty());
    }
}
