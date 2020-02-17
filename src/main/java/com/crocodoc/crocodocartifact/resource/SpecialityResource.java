package com.crocodoc.crocodocartifact.resource;

import com.crocodoc.crocodocartifact.model.Speciality;
import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class SpecialityResource {
    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/specialities/{key}")
    public List<Speciality> getAll(@PathVariable String key) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return specialityService.getAll();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/specialities/{key}")
    public ResponseEntity<Speciality> post(@PathVariable String key, @Valid @RequestBody Speciality speciality) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return new ResponseEntity<>(specialityService.create(speciality), HttpStatus.CREATED);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("specialities/{key}/{id}")
    public Optional<Speciality> getOne(@PathVariable String key, @PathVariable Long id) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return specialityService.getOne(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("specialities/{key}/{id}")
    public Speciality put(@PathVariable String key, @PathVariable Long id, @Valid  @RequestBody Speciality speciality) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return specialityService.update(speciality);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }
}
