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
    private UserService userService;
    @Autowired
    private StructureService structureService;

    @GetMapping("/user")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/user")
    public User post(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/user/{key}")
    public Optional<User> getOne(@PathVariable String key) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return userService.getUser(p.getId());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }



    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/user/{key}")
    public User update(@PathVariable String key,@RequestBody User user) {
        User p=Authentification.getUser(key);
        if(p!=null && p.getId()==user.getId()) {
            return userService.updateUser(user);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/user/{key}/{id}")
    public User updateUserForAdmin(@PathVariable String key,@RequestBody User user, @PathVariable Long id) {
        User p=Authentification.getUser(key);

        if(p!=null) {
            return userService.updateUserForAdmin(id, user);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/user/{key}/{id}")
    public Optional<User> getUserForAdmin(@PathVariable String key,@RequestBody User user, @PathVariable Long id) {
        User p=Authentification.getUser(key);

        if(p!=null) {
            return userService.getUser(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

}
