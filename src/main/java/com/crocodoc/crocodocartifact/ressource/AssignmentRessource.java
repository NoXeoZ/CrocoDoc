package com.crocodoc.crocodocartifact.ressource;

import com.crocodoc.crocodocartifact.model.Assignment;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.service.AssignmentService;
import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AssignmentRessource {
    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private StructureService structureService;

    @GetMapping("/affectations")
    public Iterable<Assignment> getAll() {
        return assignmentService.getAll();
    }

    @PostMapping("/affectations")
    public Assignment create(@Valid @RequestBody Assignment assignment) {
        Optional<Structure> structure=(structureService.getOne(assignment.getService().getId()));
        assignment.setService(structure.get());
        return assignmentService.create(assignment);
    }

    @GetMapping("affectations/{id}")
    public Optional<Assignment> getOne(@PathVariable Long id) {
        try {
            return assignmentService.getOne(id);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  l'id  "+  id  +  " inconnu");
        }
    }

    @DeleteMapping("affectations/{id}")
    public void delete(@PathVariable Long id) {
        assignmentService.delete(id);
    }

    /*
    TODO : refaire la methode du service avant de remove commentaire

    @PostMapping("affectations/{id}")
    public Assignment update( @Valid @PathVariable Long id, @RequestBody Assignment assignment) {
        return assignmentService.update(id, assignment);
    }*/
}
