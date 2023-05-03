package com.ramirez.springstudy.controller;

import com.ramirez.springstudy.entities.DoctorEntity;
import com.ramirez.springstudy.models.doctor.CreateDoctorDto;
import com.ramirez.springstudy.models.doctor.DoctorDetailingDto;
import com.ramirez.springstudy.models.doctor.FindDoctorDto;
import com.ramirez.springstudy.models.doctor.UpdateDoctorDto;
import com.ramirez.springstudy.repository.DoctorRepository;
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
    public ResponseEntity create(@RequestBody @Valid CreateDoctorDto data, UriComponentsBuilder uriBuilder) {
        var doctor = new DoctorEntity(data);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailingDto(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<FindDoctorDto>> find(
            @PageableDefault(size = 10, sort = {"name"})
            Pageable page) {

        return ResponseEntity.ok(doctorRepository.findAllByStatusTrue(page)
                .map(FindDoctorDto::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDoctorDto data) {
        var medico = doctorRepository.getReferenceById(data.id());
        medico.updateData(data);

        return ResponseEntity.ok(new DoctorDetailingDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailingDto(doctor));
    }
}
