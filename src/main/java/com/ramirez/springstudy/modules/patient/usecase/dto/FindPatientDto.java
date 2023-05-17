package com.ramirez.springstudy.modules.patient.usecase.dto;

import com.ramirez.springstudy.modules.patient.domain.entities.Patient;

public record FindPatientDto(Long id, String name, String email, String cpf) {

    public FindPatientDto(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
