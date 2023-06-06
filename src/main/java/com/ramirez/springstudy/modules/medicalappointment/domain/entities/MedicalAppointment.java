package com.ramirez.springstudy.modules.medicalappointment.domain.entities;

import com.ramirez.springstudy.infra.exceptions.ValidationException;
import com.ramirez.springstudy.modules.doctor.domain.entities.Doctor;
import com.ramirez.springstudy.modules.patient.domain.entities.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity(name = "medical_appointment")
@Table(name = "medical_appointment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicalAppointment {

    private static final String ID_DOCTOR_VALIDATION = "doctor id cannot be null";
    private static final String ID_PATIENT_VALIDATION = "patient id cannot be null";
    private static final String NULL_DATE_VALIDATION = "date cannot be null";
    private static final String PAST_DATE_VALIDATION = "the date of the medical appointment cannot be less than today's date";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", referencedColumnName = "id")
    @NotNull(message = ID_DOCTOR_VALIDATION)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient", referencedColumnName = "id")
    @NotNull(message = ID_PATIENT_VALIDATION)
    private Patient patient;

    @NotNull(message = NULL_DATE_VALIDATION)
    @Future(message = PAST_DATE_VALIDATION)
    private LocalDateTime date;

    public void validateOpeningHours() throws ValidationException {
        boolean isSunday = this.date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean isBeforeOpening = this.date.getHour() < 7;
        boolean isAfterClosing = this.date.getHour() > 18;

        if(isSunday || isBeforeOpening || isAfterClosing) {
            throw new ValidationException("Medical appointment outside opening hours!");
        }
    }

    public void validatePriorAppointment() throws ValidationException {
        Long minutes = Duration.between(this.date, LocalDateTime.now()).toMinutes();

        if(minutes < 30) {
            throw new ValidationException("Appointment must be scheduled 30 minutes before!");
        }
    }
}
