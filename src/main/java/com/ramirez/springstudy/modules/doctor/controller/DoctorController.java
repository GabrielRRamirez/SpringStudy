package com.ramirez.springstudy.modules.doctor.controller;

import com.ramirez.springstudy.modules.doctor.usecase.CreateDoctor;
import com.ramirez.springstudy.modules.doctor.usecase.FindDoctor;
import com.ramirez.springstudy.modules.doctor.usecase.FindDoctorById;
import com.ramirez.springstudy.modules.doctor.usecase.UpdateDoctor;
import com.ramirez.springstudy.modules.doctor.usecase.dto.CreateDoctorDto;
import com.ramirez.springstudy.modules.doctor.usecase.dto.DoctorDetailingDto;
import com.ramirez.springstudy.modules.doctor.usecase.dto.FindDoctorDto;
import com.ramirez.springstudy.modules.doctor.usecase.dto.UpdateDoctorDto;
import com.ramirez.springstudy.modules.doctor.repository.DoctorRepository;
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
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<DoctorDetailingDto> create(@RequestBody @Valid CreateDoctorDto data, UriComponentsBuilder uriBuilder) {
        return new CreateDoctor(doctorRepository).execute(data, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<FindDoctorDto>> find(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return new FindDoctor(doctorRepository).execute(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DoctorDetailingDto> update(@RequestBody @Valid UpdateDoctorDto updateDoctor) {
        return new UpdateDoctor(doctorRepository).execute(updateDoctor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailingDto> findById(@PathVariable Long id) {
        return new FindDoctorById(doctorRepository).execute(id);
    }
}
