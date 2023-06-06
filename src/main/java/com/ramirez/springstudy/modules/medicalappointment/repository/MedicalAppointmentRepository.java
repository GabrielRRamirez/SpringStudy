package com.ramirez.springstudy.modules.medicalappointment.repository;

import com.ramirez.springstudy.modules.medicalappointment.domain.entities.MedicalAppointment;
import com.ramirez.springstudy.modules.medicalappointment.gateways.MedicalAppointmentGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long>, MedicalAppointmentGateway {

    MedicalAppointment save(MedicalAppointment medicalAppointment);

    Page<MedicalAppointment> findAll(Pageable pageable);

    MedicalAppointment getReferenceById(Long id);
}
