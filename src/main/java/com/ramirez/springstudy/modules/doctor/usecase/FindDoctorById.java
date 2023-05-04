package com.ramirez.springstudy.modules.doctor.usecase;

import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import com.ramirez.springstudy.modules.doctor.usecase.dto.DoctorDetailingDto;
import org.springframework.http.ResponseEntity;

public class FindDoctorById {

    private final DoctorGateway doctorGateway;

    public FindDoctorById(DoctorGateway doctorGateway) {
        this.doctorGateway = doctorGateway;
    }

    public ResponseEntity<DoctorDetailingDto> execute(Long id) {
        var doctor = doctorGateway.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailingDto(doctor));
    }
}
