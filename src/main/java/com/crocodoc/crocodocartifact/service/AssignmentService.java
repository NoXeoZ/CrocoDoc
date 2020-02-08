package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Assignment;
import com.crocodoc.crocodocartifact.repository.AssignmentRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository  assignmentRepository;

    public Iterable<Assignment> getAll() {
        return assignmentRepository.findAll();
    }

    public Assignment create(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<Assignment> getOne(long id) {
        return Optional.ofNullable(assignmentRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public void delete(long id) {
        assignmentRepository.deleteById(id);
    }

    /*
    TODO : a refaire -> setId() n'existe pas et ne doit pas exister

    public Assignment update(Long id, Assignment assignment) {
        assignmentRepository.findById(id).orElseThrow(NotFoundException::new);
        assignment.setId(id);
        return assignmentRepository.save(assignment);
    }*/
}
