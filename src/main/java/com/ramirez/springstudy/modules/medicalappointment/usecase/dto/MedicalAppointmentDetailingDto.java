package com.ramirez.springstudy.modules.medicalappointment.usecase.dto;


import com.ramirez.springstudy.modules.medicalappointment.domain.entities.MedicalAppointment;

import java.time.LocalDateTime;

public record MedicalAppointmentDetailingDto(
        Long id,
        Long idDoctor,
        Long idPatient,
        LocalDateTime date) {

    public MedicalAppointmentDetailingDto(MedicalAppointment medicalAppointment) {
        this(medicalAppointment.getId(), medicalAppointment.getDoctor().getId(), medicalAppointment.getPatient().getId(), medicalAppointment.getDate());
    }
}
