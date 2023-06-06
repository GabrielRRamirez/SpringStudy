package com.ramirez.springstudy.modules.medicalappointment.gateways;

import com.ramirez.springstudy.modules.medicalappointment.domain.entities.MedicalAppointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicalAppointmentGateway {

    MedicalAppointment save(MedicalAppointment medicalAppointment);

    Page<MedicalAppointment> findAll(Pageable pageable);

    MedicalAppointment getReferenceById(Long id);
}
