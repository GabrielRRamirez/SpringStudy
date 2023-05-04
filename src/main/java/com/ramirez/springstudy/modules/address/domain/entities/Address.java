package com.ramirez.springstudy.modules.address.domain.entities;

import com.ramirez.springstudy.modules.doctor.usecase.dto.AddressDoctorDto;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private static final String PUBLIC_PLACE_VALIDATION = "the public place should not be empty";
    private static final String NEIGHBORHOOD_VALIDATION = "the neighborhood should not be empty";
    private static final String CEP_VALIDATION = "the phone must have 8 numbers";
    private static final String CITY_VALIDATION = "the city should not be empty";
    private static final String UF_VALIDATION = "the UF should not be empty";

    @NotBlank(message = PUBLIC_PLACE_VALIDATION)
    private String publicPlace;

    @NotBlank(message = NEIGHBORHOOD_VALIDATION)
    private String neighborhood;

    @NotBlank(message = CEP_VALIDATION)
    @Pattern(regexp = "\\d{8}", message = CEP_VALIDATION)
    private String cep;
    private String number;
    private String complement;

    @NotBlank(message = CITY_VALIDATION)
    private String city;

    @NotBlank(message = UF_VALIDATION)
    private String uf;

    public Address(AddressDoctorDto address) {
        this.publicPlace = address.publicPlace();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.number = address.number();
        this.complement = address.complement();
        this.city = address.city();
        this.uf = address.uf();
    }

    public void atualizarInformacoes(AddressDoctorDto dadosEndereco) {

        if(dadosEndereco.publicPlace() != null) {
            this.publicPlace = dadosEndereco.publicPlace();
        }

        if(dadosEndereco.neighborhood() != null) {
            this.neighborhood = dadosEndereco.neighborhood();
        }

        if(dadosEndereco.number() != null) {
            this.number = dadosEndereco.number();
        }

        if(dadosEndereco.cep() != null) {
            this.cep = dadosEndereco.cep();
        }

        if(dadosEndereco.complement() != null) {
            this.complement = dadosEndereco.complement();
        }

        if(dadosEndereco.city() != null) {
            this.city = dadosEndereco.city();
        }

        if(dadosEndereco.uf() != null) {
            this.uf = dadosEndereco.uf();
        }
    }
}
