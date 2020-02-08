package com.crocodoc.crocodocartifact.ressource;

import com.crocodoc.crocodocartifact.model.Affectation;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.service.AffectationService;
import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class affectationRessource {
    @Autowired
    private AffectationService affectationService;
    @Autowired
    private StructureService structureService;

    @GetMapping("/affectations")
    public Iterable<Affectation> getAll() {
        return affectationService.getAll();
    }

    @PostMapping("/affectations")
    public Affectation create(@Valid @RequestBody Affectation affectation) {
        Optional<Structure> structure=(structureService.getOne(affectation.getStructure().getId()));
        affectation.setStructure(structure.get());
        return affectationService.create(affectation);
    }

    @GetMapping("affectations/{id}")
    public Optional<Affectation> getOne(@PathVariable Long id) {
        try {
            return affectationService.getOne(id);
        }catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  l'id  "+  id  +  " inconnu");
        }
    }

    @DeleteMapping("affectations/{id}")
    public void delete(@PathVariable Long id) {
        affectationService.delete(id);
    }

    @PostMapping("affectations/{id}")
    public Affectation update( @Valid @PathVariable Long id, @RequestBody Affectation affectation) {
        return affectationService.update(id, affectation);
    }
}
