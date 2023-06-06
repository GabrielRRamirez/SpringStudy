package com.ramirez.springstudy.modules.patient.gateways;

import com.ramirez.springstudy.modules.patient.domain.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PatientGateway {

    Patient save(Patient patient);
    Page<Patient> findAllByStatusTrue(Pageable pageable);
    Patient getReferenceById(Long id);

    Optional<Patient> findById(Long idPatient);

    boolean existsById(Long idPatient);
}
