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

    public Assignment update(Long id, Assignment assignment) {
        assignmentRepository.findById(id).orElseThrow(NotFoundException::new);
        return assignmentRepository.save(assignment);
    }
}
