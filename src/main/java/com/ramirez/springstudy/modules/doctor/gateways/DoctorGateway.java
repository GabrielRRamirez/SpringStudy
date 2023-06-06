package com.ramirez.springstudy.modules.doctor.gateways;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.doctor.domain.enums.Specialty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface DoctorGateway {

    Doctor save(Doctor doctor);
    Page<Doctor> findAllByStatusTrue(Pageable pageable);

    Doctor getReferenceById(Long id);

    Optional<Doctor> findById(Long idDoctor);

    boolean existsById(Long idDoctor);

    Doctor chooseRandomDoctor(Specialty specialty, LocalDateTime date);
}
