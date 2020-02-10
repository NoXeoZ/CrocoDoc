package com.crocodoc.crocodocartifact.resource;

import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StructureResource {
    @Autowired
    private StructureService structureService;

    @GetMapping("/structures/{key}")
    public List<Structure> getAll(@PathVariable String key) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            return structureService.getAll();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/structures/{key}")
    public ResponseEntity<Structure> post(@PathVariable String key, @Valid @RequestBody Structure structure) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            return new ResponseEntity<>(structureService.create(structure), HttpStatus.CREATED);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("structures/{key}/{id}")
    public Optional<Structure> getOne(@PathVariable String key, @PathVariable Long id) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            return structureService.getOne(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @DeleteMapping("structures/{key}/{id}")
    public void delete(@PathVariable String key, @PathVariable Long id) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            structureService.delete(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("structures/{key}/{id}")
    public Structure put(@PathVariable String key, @PathVariable Long id, @Valid  @RequestBody Structure structure) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            return structureService.update(structure);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }
}
