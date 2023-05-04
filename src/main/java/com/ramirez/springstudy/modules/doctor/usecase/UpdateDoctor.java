package com.ramirez.springstudy.modules.doctor.usecase;

import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import com.ramirez.springstudy.modules.doctor.usecase.dto.DoctorDetailingDto;
import com.ramirez.springstudy.modules.doctor.usecase.dto.UpdateDoctorDto;
import org.springframework.http.ResponseEntity;

public class UpdateDoctor {

    private final DoctorGateway doctorGateway;

    public UpdateDoctor(DoctorGateway doctorGateway) {
        this.doctorGateway = doctorGateway;
    }

    public ResponseEntity<DoctorDetailingDto> execute(UpdateDoctorDto updateDoctor) {
        var doctor = doctorGateway.getReferenceById(updateDoctor.id());
        doctor.updateData(updateDoctor);

        return ResponseEntity.ok(new DoctorDetailingDto(doctor));
    }
}
