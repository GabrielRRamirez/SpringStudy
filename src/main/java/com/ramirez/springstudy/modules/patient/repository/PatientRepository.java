package com.ramirez.springstudy.modules.patient.repository;

import com.ramirez.springstudy.modules.patient.domain.entities.Patient;
import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, PatientGateway {

    Patient save(Patient patient);
    Page<Patient> findAllByStatusTrue(Pageable pageable);
    Patient getReferenceById(Long id);
}
