package com.crocodoc.crocodocartifact.ressource;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class structureRessource {
    @Autowired
    private StructureService structureService;

    @GetMapping("/structures")
    public Iterable<Structure> getAll() {
        return structureService.getAll();
    }

    @PostMapping("/structures")
    public ResponseEntity<Structure> post(@Valid @RequestBody Structure structure) {
        return new ResponseEntity<>(structureService.create(structure), HttpStatus.CREATED);

    }

    @GetMapping("structures/{id}")
    public Optional<Structure> getOne(@PathVariable Long id) {
        try{
            return structureService.getOne(id);
        }catch(NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  l'id  "+  id  +  " inconnu");
        }
    }

    @DeleteMapping("structures/{id}")
    public void delete(@PathVariable Long id) {
        structureService.delete(id);
    }

    @PostMapping("structures/{id}")
    public Structure put(@PathVariable Long id,@Valid  @RequestBody Structure structure) {
        return structureService.update(id, structure);
    }
}
