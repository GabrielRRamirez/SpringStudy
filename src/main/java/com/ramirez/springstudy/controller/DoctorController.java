package com.ramirez.springstudy.controller;

import com.ramirez.springstudy.entities.DoctorEntity;
import com.ramirez.springstudy.models.doctor.UpdateDoctorDto;
import com.ramirez.springstudy.models.doctor.CreateDoctorDto;
import com.ramirez.springstudy.models.doctor.FindDoctorDto;
import com.ramirez.springstudy.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public void create(@RequestBody @Valid CreateDoctorDto data) {
        doctorRepository.save(new DoctorEntity(data));
    }

    @GetMapping
    public Page<FindDoctorDto> find(
            @PageableDefault(size = 10, sort = {"name"})
            Pageable page) {
        return doctorRepository.findAllByStatusTrue(page)
                .map(FindDoctorDto::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorDto data) {
        var medico = doctorRepository.getReferenceById(data.id());
        medico.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
    }
}
