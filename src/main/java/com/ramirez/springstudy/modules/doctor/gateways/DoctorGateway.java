package com.ramirez.springstudy.modules.doctor.gateways;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorGateway {

    Doctor save(Doctor doctor);
    Page<Doctor> findAllByStatusTrue(Pageable pageable);

    Doctor getReferenceById(Long id);
}
