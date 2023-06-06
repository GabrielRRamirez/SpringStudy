package com.ramirez.springstudy.modules.medicalappointment.usecase.dto;

import com.ramirez.springstudy.modules.doctor.domain.enums.Specialty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateMedicalAppointmentDto(

        Long idDoctor,

        @NotNull(message = ID_PATIENT_VALIDATION)
        Long idPatient,

        LocalDateTime date,

        Specialty specialty) {

    private static final String ID_PATIENT_VALIDATION = "patient id cannot be null";
}
