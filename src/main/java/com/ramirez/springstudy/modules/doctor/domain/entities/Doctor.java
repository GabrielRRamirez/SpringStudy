package com.ramirez.springstudy.modules.doctor.domain.entities;

import com.ramirez.springstudy.modules.doctor.usecase.dto.UpdateDoctorDto;
import com.ramirez.springstudy.modules.doctor.usecase.dto.CreateDoctorDto;
import com.ramirez.springstudy.modules.doctor.domain.enums.specialty;
import com.ramirez.springstudy.modules.address.domain.entities.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Doctor {

    private static final String NAME_VALIDATION = "the name should not be empty";
    private static final String EMAIL_VALIDATION = "the email should be valid. Example: example@example.com";
    private static final String TELEPHONE_VALIDATION = "the phone must have between 9 and 11 numbers";
    private static final String CRM_VALIDATION = "the CRM must have 6 numbers";
    private static final String EMPTY_CRM_VALIDATION = "the CRM should not be empty";
    private static final String ADDRESS_VALIDATION = "the address should not be empty";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = NAME_VALIDATION)
    private String name;

    @NotBlank
    @Email(message = EMAIL_VALIDATION)
    private String email;

    @NotBlank(message = TELEPHONE_VALIDATION)
    @Pattern(regexp = "\\d{9,11}", message = TELEPHONE_VALIDATION)
    private String telephone;

    @NotBlank(message = EMPTY_CRM_VALIDATION)
    @Pattern(regexp = "\\d{4,6}", message = CRM_VALIDATION)
    private String crm;

    @Enumerated(EnumType.STRING)
    private specialty specialty;

    @NotNull(message = ADDRESS_VALIDATION)
    @Valid
    @Embedded
    private Address address;

    private Boolean status;

    public Doctor(CreateDoctorDto data) {
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.address = new Address(data.address());
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
