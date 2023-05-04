package com.ramirez.springstudy.modules.doctor.usecase;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import com.ramirez.springstudy.modules.doctor.usecase.dto.CreateDoctorDto;
import com.ramirez.springstudy.modules.doctor.usecase.dto.DoctorDetailingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class CreateDoctor {

    private final DoctorGateway doctorGateway;

    public CreateDoctor(DoctorGateway doctorGateway) {
        this.doctorGateway = doctorGateway;
    }

    public ResponseEntity<DoctorDetailingDto> execute(CreateDoctorDto createDoctorDto, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(createDoctorDto);
        doctorGateway.save(doctor);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailingDto(doctor));
    }
}
