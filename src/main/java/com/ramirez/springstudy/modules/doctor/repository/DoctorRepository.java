package com.ramirez.springstudy.modules.doctor.repository;

import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.doctor.domain.enums.Specialty;
import com.ramirez.springstudy.modules.doctor.gateways.DoctorGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>, DoctorGateway {
    Page<Doctor> findAllByStatusTrue(Pageable page);
    Doctor getReferenceById(Long id);
    Doctor save(Doctor doctor);

    @Query("""
            SELECT d
            FROM Doctor d
            WHERE
            d.status = TRUE
            AND d.specialty = :specialty
            AND d.id NOT IN (
                SELECT m.doctor.id FROM medical_appointment m
                WHERE m.date = :date
            )
            ORDER BY RANDOM()
            LIMIT 1
            """)
    Doctor chooseRandomDoctor(Specialty specialty, LocalDateTime date);
}
