package com.ramirez.springstudy.modules.medicalappointment.controller;

import com.ramirez.springstudy.infra.exceptions.ValidationException;
import com.ramirez.springstudy.modules.doctor.repository.DoctorRepository;
import com.ramirez.springstudy.modules.medicalappointment.repository.MedicalAppointmentRepository;
import com.ramirez.springstudy.modules.medicalappointment.usecase.CreateMedicalAppointment;
import com.ramirez.springstudy.modules.medicalappointment.usecase.dto.CreateMedicalAppointmentDto;
import com.ramirez.springstudy.modules.medicalappointment.usecase.dto.MedicalAppointmentDetailingDto;
import com.ramirez.springstudy.modules.patient.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medical-appointment")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<MedicalAppointmentDetailingDto> create(@RequestBody @Valid CreateMedicalAppointmentDto createMedicalAppointmentDto, UriComponentsBuilder uriBuilder) throws ValidationException {
        return new CreateMedicalAppointment(
                medicalAppointmentRepository,
                doctorRepository,
                patientRepository).execute(createMedicalAppointmentDto, uriBuilder);
    }
}
