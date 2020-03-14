package com.crocodoc.crocodocartifact.resource;


import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class UserResource {
    @Autowired
    private UserService profileService;
    @Autowired
    private StructureService structureService;

    @GetMapping("/user/{key}")
    public Iterable<User> getAll(@PathVariable String key) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return profileService.getAll();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/user/{key}")
    public User post(@RequestBody User profile, @PathVariable String key) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return profileService.create(profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/user/{id}/{key}")
    public Optional<User> getOne(@PathVariable long id, @PathVariable String key) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return profileService.getUser(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }



    @DeleteMapping("/user/{id}/{key}")
    public void delete(@PathVariable Long id, @PathVariable String key) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            profileService.deleteUser(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    /*@PostMapping("/user/{key}")
    public User update(@PathVariable String key,@RequestBody User profile) {
        User p=Authentification.getUser(key);
        if(p!=null && p.getId()==profile.getId()) {
            return profileService.updateUser(profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }*/
}
