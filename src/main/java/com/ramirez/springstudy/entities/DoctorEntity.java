package com.ramirez.springstudy.entities;

import com.ramirez.springstudy.models.doctor.UpdateDoctorDto;
import com.ramirez.springstudy.models.doctor.CreateDoctorDto;
import com.ramirez.springstudy.models.doctor.specialty;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private specialty specialty;

    @Embedded
    private AddressEntity address;

    private Boolean status;

    public DoctorEntity(CreateDoctorDto data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.address = new AddressEntity(data.address());
        this.specialty = data.specialty();
        this.status = true;
    }

    public void updateData(UpdateDoctorDto data) {
        if(data.name() != null && !data.name().isEmpty()) {
            this.name = data.name();
        }

        if(data.telephone() != null) {
            this.telephone = data.telephone();
        }

        if(data.address() != null) {
            this.address.atualizarInformacoes(data.address());
        }
    }

    public void delete() {
        this.status = false;
    }
}
