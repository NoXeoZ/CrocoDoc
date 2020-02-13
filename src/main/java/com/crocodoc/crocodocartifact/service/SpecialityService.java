package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Speciality;
import com.crocodoc.crocodocartifact.repository.SpecialityRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;

    public Speciality create(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    public Speciality update(Speciality speciality) {
        specialityRepository.findById(speciality.getId()).orElseThrow(NotFoundException::new);
        return specialityRepository.save(speciality);
    }

    public Optional<Speciality> getOne(Long id) {
        return Optional.ofNullable(specialityRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public List<Speciality> getAll(){
        return specialityRepository.findAll();
    }
}
