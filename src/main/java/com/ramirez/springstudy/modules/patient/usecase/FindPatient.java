package com.ramirez.springstudy.modules.patient.usecase;

import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import com.ramirez.springstudy.modules.patient.usecase.dto.FindPatientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class FindPatient {

    private final PatientGateway patientGateway;

    public FindPatient(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }

    public ResponseEntity<Page<FindPatientDto>> execute(Pageable pageable) {
        return ResponseEntity.ok(patientGateway.findAllByStatusTrue(pageable).map(FindPatientDto::new));
    }
}
