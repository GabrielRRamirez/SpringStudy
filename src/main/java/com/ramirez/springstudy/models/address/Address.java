package com.ramirez.springstudy.models.address;

import com.ramirez.springstudy.entities.AddressEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Address(

        @NotBlank
        String publicPlace,

        @NotBlank
        String neighborhood,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String city,

        @NotBlank
        String uf,


        String complement,


        String number) {

    public Address(AddressEntity addressEntity) {
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
