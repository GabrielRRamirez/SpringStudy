package com.ramirez.springstudy.modules.patient.controller;

import com.ramirez.springstudy.modules.patient.repository.PatientRepository;
import com.ramirez.springstudy.modules.patient.usecase.*;
import com.ramirez.springstudy.modules.patient.usecase.dto.CreatePatientDto;
import com.ramirez.springstudy.modules.patient.usecase.dto.FindPatientDto;
import com.ramirez.springstudy.modules.patient.usecase.dto.PatientDetailingDto;
import com.ramirez.springstudy.modules.patient.usecase.dto.UpdatePatientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDetailingDto> create(@RequestBody @Valid CreatePatientDto createPatientDto, UriComponentsBuilder uriBuilder) {
        return new CreatePatient(patientRepository).execute(createPatientDto, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<FindPatientDto>> findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        return new FindPatient(patientRepository).execute(paginacao);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdatePatientDto updatePatientDto) {
        return new UpdatePatient(patientRepository).execute(updatePatientDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        return new DeletePatient(patientRepository).execute(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new FindPatientById(patientRepository).execute(id);
    }
}
