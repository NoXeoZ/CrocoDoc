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

    @GetMapping("/profile")
    public Iterable<User> getAll() {
        return profileService.getAll();
    }

    @PostMapping("/profile")
    public User post(@RequestBody User profile) {
        return profileService.create(profile);
    }

    @GetMapping("/profile/{key}")
    public Optional<User> getOne(@PathVariable String key) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return profileService.getUser(p.getId());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }



    @DeleteMapping("/profile/{id}")
    public void delete(@PathVariable Long id) {
        profileService.deleteUser(id);
    }

    @PostMapping("/profile/{key}")
    public User update(@PathVariable String key,@RequestBody User profile) {
        User p=Authentification.getUser(key);
        if(p!=null && p.getId()==profile.getId()) {
            return profileService.updateUser(profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/profile/{key}/{id}")
    public User updateUserForAdmin(@PathVariable String key,@RequestBody User profile, @PathVariable Long id) {
        User p=Authentification.getUser(key);

        if(p!=null) {
            return profileService.updateUserForAdmin(id, profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/profile/{key}/{id}")
    public Optional<User> getUserForAdmin(@PathVariable String key,@RequestBody User profile, @PathVariable Long id) {
        User p=Authentification.getUser(key);

        if(p!=null) {
            return profileService.getUser(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

}
