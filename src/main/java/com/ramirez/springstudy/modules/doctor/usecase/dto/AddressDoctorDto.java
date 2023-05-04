package com.ramirez.springstudy.modules.doctor.usecase.dto;

import com.ramirez.springstudy.modules.address.domain.entities.Address;

public record AddressDoctorDto(
        String publicPlace,
        String neighborhood,
        String cep,
        String city,
        String uf,
        String complement,
        String number) {

    public AddressDoctorDto(Address addressEntity) {
        this(
                addressEntity.getPublicPlace(),
                addressEntity.getNeighborhood(),
                addressEntity.getCep(),
                addressEntity.getCity(),
                addressEntity.getUf(),
                addressEntity.getComplement(),
                addressEntity.getNumber());
    }
}
