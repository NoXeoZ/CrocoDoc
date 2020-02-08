package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Affectation;
import com.crocodoc.crocodocartifact.repository.AffectationRepository;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AffectationService {
    @Autowired
    private AffectationRepository affectationRepository;
    public Iterable<Affectation> getAll() {
        return affectationRepository.findAll();
    }

    public Affectation create(Affectation affectation) {
        return affectationRepository.save(affectation);
    }

    public Optional<Affectation> getOne(Long id) {
        return Optional.ofNullable(affectationRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public void delete(Long id) {
        affectationRepository.deleteById(id);
    }

    public Affectation update(Long id, Affectation affectation) {
        affectationRepository.findById(id).orElseThrow(NotFoundException::new);
        affectation.setId(id);
        return affectationRepository.save(affectation);
    }
}
