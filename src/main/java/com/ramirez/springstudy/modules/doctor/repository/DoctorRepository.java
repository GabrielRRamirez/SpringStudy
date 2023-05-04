package com.ramirez.springstudy.modules.doctor.repository;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>, DoctorGateway {
    Page<Doctor> findAllByStatusTrue(Pageable page);
    Doctor getReferenceById(Long id);
    Doctor save(Doctor doctor);
}
