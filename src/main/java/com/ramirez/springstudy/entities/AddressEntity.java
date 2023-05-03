package com.ramirez.springstudy.entities;

import com.ramirez.springstudy.models.address.Address;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private String publicPlace;
    private String neighborhood;
    private String cep;
    private String number;
    private String complement;
    private String city;
    private String uf;

    public AddressEntity(Address address) {
        this.publicPlace = address.publicPlace();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.number = address.number();
        this.complement = address.complement();
        this.city = address.city();
        this.uf = address.uf();
    }

    public void atualizarInformacoes(Address dadosEndereco) {

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
