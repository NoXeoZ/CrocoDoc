package com.crocodoc.crocodocartifact.ressources;


import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.service.ProfileService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/structures")
    public Iterable<Profile> getAll() {
        return profileService.getAll();
    }

    @PostMapping("/structures")
    public ResponseEntity<Profile> post(@Valid @RequestBody Profile structure) {
        return new ResponseEntity<>(profileService.create(structure), HttpStatus.CREATED);
    }

    @GetMapping("structures/{id}")
    public Optional<Profile> getOne(@PathVariable Long id) {
        try{
            return profileService.getProfileInfosForAdmin(Math.toIntExact(id));
        }catch(NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  l'id  "+  id  +  " inconnu");
        }
    }

    @DeleteMapping("structures/{id}")
    public void delete(@PathVariable Long id) {
        profileService.deleteProfile(Math.toIntExact(id));
    }

    @PostMapping("structures/{id}")
    public Profile put(@PathVariable Long id,@Valid  @RequestBody Profile profile) {
        return profileService.updateProfileForAdmin(Math.toIntExact(id), profile);
    }




}
