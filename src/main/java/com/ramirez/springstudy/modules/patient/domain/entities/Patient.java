package com.ramirez.springstudy.modules.patient.domain.entities;

import com.ramirez.springstudy.modules.address.domain.entities.Address;
import com.ramirez.springstudy.modules.patient.usecase.dto.CreatePatientDto;
import com.ramirez.springstudy.modules.patient.usecase.dto.UpdatePatientDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patient")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    private static final String NAME_VALIDATION = "the name should not be empty";
    private static final String EMAIL_VALIDATION = "the email should be valid. Example: example@example.com";
    private static final String TELEPHONE_VALIDATION = "the phone must have between 9 and 11 numbers";
    private static final String CPF_VALIDATION = "the CPF must have 9 numbers";

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

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = CPF_VALIDATION)
    private String cpf;

    @Embedded
    @Valid
    private Address address;

    private Boolean status;

    public Patient(CreatePatientDto createPatientDto) {
        this.status = true;
        this.name = createPatientDto.name();
        this.email = createPatientDto.email();
        this.telephone = createPatientDto.telephone();
        this.cpf = createPatientDto.cpf();
        this.address = new Address(createPatientDto.address());
    }

    public void update(UpdatePatientDto updatePatientDto) {
        if (updatePatientDto.name() != null) {
            this.name = updatePatientDto.name();
        }
        if (updatePatientDto.telephone() != null) {
            this.telephone = updatePatientDto.telephone();
        }
        if (updatePatientDto.address() != null) {
            this.address.atualizarInformacoes(updatePatientDto.address());
        }
    }

    public void delete() {
        this.status = false;
    }
}
