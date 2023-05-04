package com.ramirez.springstudy.modules.doctor.usecase;

import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import com.ramirez.springstudy.modules.doctor.usecase.dto.FindDoctorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public class FindDoctor {

    private final DoctorGateway doctorGateway;

    public FindDoctor(DoctorGateway doctorGateway) {
        this.doctorGateway = doctorGateway;
    }

    public ResponseEntity<Page<FindDoctorDto>> execute(Pageable pageable) {
        return ResponseEntity.ok(doctorGateway.findAllByStatusTrue(pageable)
                .map(FindDoctorDto::new));
    }
}
