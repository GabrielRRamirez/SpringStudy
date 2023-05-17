package com.ramirez.springstudy.modules.patient.usecase;

import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import org.springframework.http.ResponseEntity;

public class DeletePatient {

    private final PatientGateway patientGateway;

    public DeletePatient(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }

    public ResponseEntity execute(Long id) {
        var patient = patientGateway.getReferenceById(id);
        patient.delete();
        return ResponseEntity.noContent().build();
    }
}
