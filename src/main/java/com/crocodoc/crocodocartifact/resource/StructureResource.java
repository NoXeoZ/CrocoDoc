package com.crocodoc.crocodocartifact.resource;

import com.crocodoc.crocodocartifact.model.Speciality;
import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.service.SpecialityService;
import com.crocodoc.crocodocartifact.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StructureResource {
    @Autowired
    private StructureService structureService;
    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/structures/{key}")
    public List<Structure> getAll(@PathVariable String key) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return structureService.getAll();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/structures/{key}")
    public Structure post(@PathVariable String key, @Valid @RequestBody Structure structure) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return structureService.create(structure);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("structures/{key}/{id}")
    public Structure getOne(@PathVariable String key, @PathVariable Long id) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return structureService.getOne(id).get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("structures/getSpeciality/{key}/{id}")
    public Optional<Speciality> getSpecialityFromStructure(@PathVariable Long id, @PathVariable String key) {
        System.out.println("get speciality");
        long idSpeciality=structureService.getOne(id).get().getSpeciality().getId();
        System.out.println("get speciality  iiidddd==+>"+idSpeciality);
        User p=Authentification.getUser(key);
        if(p!=null) {
            return specialityService.getOne(idSpeciality);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @DeleteMapping("structures/{key}/{id}")
    public void delete(@PathVariable String key, @PathVariable Long id) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            structureService.delete(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("structures/{key}/{id}")
    public Structure put(@PathVariable String key, @PathVariable Long id, @Valid  @RequestBody Structure structure) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return structureService.update(structure);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }
}
