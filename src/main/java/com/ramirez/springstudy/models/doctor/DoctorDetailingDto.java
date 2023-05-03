package com.ramirez.springstudy.models.doctor;

import com.ramirez.springstudy.entities.DoctorEntity;
import com.ramirez.springstudy.models.address.Address;

public record DoctorDetailingDto(
        Long id,
        String name,
        String email,
        String telephone,
        String crm,
        specialty specialty,
        Address address) {

    public DoctorDetailingDto(DoctorEntity doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getTelephone(),
                doctor.getCrm(),
                doctor.getSpecialty(),
                new Address(doctor.getAddress()));
    }
}
