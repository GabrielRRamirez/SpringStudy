package com.ramirez.springstudy.modules.patient.usecase.dto;

import com.ramirez.springstudy.modules.address.domain.entities.Address;
import com.ramirez.springstudy.modules.patient.domain.entities.Patient;

public record PatientDetailingDto(Long id, String name, String email, String cpf, String telephone, Address address) {

    public PatientDetailingDto(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(), patient.getTelephone(), patient.getAddress());
    }
}
