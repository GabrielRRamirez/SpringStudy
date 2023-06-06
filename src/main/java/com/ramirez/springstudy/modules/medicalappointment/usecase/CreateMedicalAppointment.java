package com.ramirez.springstudy.modules.medicalappointment.usecase;

import com.ramirez.springstudy.infra.exceptions.ValidationException;
import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import com.ramirez.springstudy.modules.medicalappointment.domain.entities.MedicalAppointment;
import com.ramirez.springstudy.modules.medicalappointment.gateways.MedicalAppointmentGateway;
import com.ramirez.springstudy.modules.medicalappointment.usecase.dto.CreateMedicalAppointmentDto;
import com.ramirez.springstudy.modules.medicalappointment.usecase.dto.MedicalAppointmentDetailingDto;
import com.ramirez.springstudy.modules.patient.gateways.PatientGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class CreateMedicalAppointment {

    private final MedicalAppointmentGateway medicalAppointmentGateway;
    private final DoctorGateway doctorGateway;
    private final PatientGateway patientGateway;

    public CreateMedicalAppointment(MedicalAppointmentGateway medicalAppointmentGateway, DoctorGateway doctorGateway, PatientGateway patientGateway) {
        this.medicalAppointmentGateway = medicalAppointmentGateway;
        this.doctorGateway = doctorGateway;
        this.patientGateway = patientGateway;
    }

    public ResponseEntity<MedicalAppointmentDetailingDto> execute(
            CreateMedicalAppointmentDto createMedicalAppointmentDto,
            UriComponentsBuilder uriBuilder) throws ValidationException {

        if(!patientGateway.existsById(createMedicalAppointmentDto.idPatient())) {
            throw new ValidationException("Entered patient id does not exist!");
        }

        if(createMedicalAppointmentDto.idDoctor() != null && !doctorGateway.existsById(createMedicalAppointmentDto.idDoctor())) {
            throw new ValidationException("Entered doctor id does not exist!");
        }

        var doctor = chooseDoctor(createMedicalAppointmentDto);
        var patient = patientGateway.findById(createMedicalAppointmentDto.idPatient()).get();

        var medicalAppointment = new MedicalAppointment(null, doctor, patient, createMedicalAppointmentDto.date());

        medicalAppointment.validateOpeningHours();
        medicalAppointment.validatePriorAppointment();

        medicalAppointmentGateway.save(medicalAppointment);

        var uri = uriBuilder.path("/medical-appointment/{id}").buildAndExpand(medicalAppointment.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicalAppointmentDetailingDto(medicalAppointment));
    }

    private Doctor chooseDoctor(CreateMedicalAppointmentDto createMedicalAppointmentDto) throws ValidationException {
        if(createMedicalAppointmentDto.idDoctor() != null) {
            return doctorGateway.getReferenceById(createMedicalAppointmentDto.idDoctor());
        }

        if(createMedicalAppointmentDto.specialty() == null) {
            throw new ValidationException("Specialty is obrigatory when doctor's id is not informed");
        }

        return doctorGateway.chooseRandomDoctor(createMedicalAppointmentDto.specialty(), createMedicalAppointmentDto.date());
    }
}
