package com.ramirez.springstudy.modules.patient.usecase;

import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import com.ramirez.springstudy.modules.patient.usecase.dto.PatientDetailingDto;
import org.springframework.http.ResponseEntity;

public class FindPatientById {

    private final PatientGateway patientGateway;

    public FindPatientById(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }

    public ResponseEntity<PatientDetailingDto> execute(Long id) {
        var paciente = patientGateway.getReferenceById(id);
        return ResponseEntity.ok(new PatientDetailingDto(paciente));
    }
}
