package com.ramirez.springstudy.modules.patient.usecase;

import com.ramirez.springstudy.modules.patient.domain.entities.Patient;
import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import com.ramirez.springstudy.modules.patient.usecase.dto.CreatePatientDto;
import com.ramirez.springstudy.modules.patient.usecase.dto.PatientDetailingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class CreatePatient {

    private final PatientGateway patientGateway;

    public CreatePatient(PatientGateway patientGateway) {
        this.patientGateway = patientGateway;
    }

    public ResponseEntity<PatientDetailingDto> execute(CreatePatientDto createPatientDto, UriComponentsBuilder uriBuilder) {
        var paciente = new Patient(createPatientDto);
        patientGateway.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDetailingDto(paciente));
    }
}
