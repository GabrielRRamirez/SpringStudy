package com.ramirez.springstudy.modules.patient.usecase;

import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import com.ramirez.springstudy.modules.patient.usecase.dto.PatientDetailingDto;
import com.ramirez.springstudy.modules.patient.usecase.dto.UpdatePatientDto;
import org.springframework.http.ResponseEntity;

public class UpdatePatient {

    private final PatientGateway patientGateway;

    public UpdatePatient(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }

    public ResponseEntity<PatientDetailingDto> execute(UpdatePatientDto updatePatientDto) {
        var patient = patientGateway.getReferenceById(updatePatientDto.id());
        patient.update(updatePatientDto);

        return ResponseEntity.ok(new PatientDetailingDto(patient));
    }
}
