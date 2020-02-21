package com.crocodoc.crocodocartifact.resource;


import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.service.StructureService;
import com.crocodoc.crocodocartifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{key}")
    public Iterable<User> getAll(@PathVariable String key) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return userService.getAll();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }

    }

    @PostMapping("/user/{key}")
    public ResponseEntity<User> post(@PathVariable String key, @Valid @RequestBody User user) {
        User p=Authentification.getUser(key);
        if(p!=null) {
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/user/{key}/{id}")
    public Optional<User> getOne(@PathVariable String key) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return userService.getUser(p.getId());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }



    @DeleteMapping("/user/{key}/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/user/{key}/{id}")
    public User update(@PathVariable String key,@RequestBody User user) {
        User p=Authentification.getUser(key);
        if(p!=null && p.getId()==user.getId()) {
            return userService.updateUser(user);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/users/{key}/{id}")
    public User updateUserForAdmin(@PathVariable String key,@RequestBody User user, @PathVariable Long id) {
        User p=Authentification.getUser(key);

        if(p!=null) {
            return userService.updateUserForAdmin(id, user);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/users/{key}/{id}")
    public Optional<User> getUserForAdmin(@PathVariable String key,@RequestBody User user, @PathVariable Long id) {
        User p=Authentification.getUser(key);

        if(p!=null) {
            return userService.getUser(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

}
