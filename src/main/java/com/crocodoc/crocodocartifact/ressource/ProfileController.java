package com.crocodoc.crocodocartifact.ressource;


import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/profile")
    public Iterable<Profile> getAll() {
        return profileService.getAll();
    }

    @PostMapping("/profile")
    public Profile post(@RequestBody Profile profile) {
        return profileService.create(profile);
    }

    @GetMapping("/profile/{key}")
    public Optional<Profile> getOne(@PathVariable String key) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            return profileService.getProfileInfos(p.getId());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }



    @DeleteMapping("/profile/{id}")
    public void delete(@PathVariable Long id) {
        profileService.deleteProfile(id);
    }

    @PostMapping("/profile/{key}")
    public Profile update(@PathVariable String key,@RequestBody Profile profile) {
        Profile p=Authentification.getProfile(key);
        if(p!=null) {
            return profileService.updateProfile(p, profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/profile/{key}/{id}")
    public Profile updateProfileForAdmin(@PathVariable String key,@RequestBody Profile profile, @PathVariable Long id) {
        Profile p=Authentification.getProfile(key);

        if(p!=null && p.isChief()) {
            return profileService.updateProfileForAdmin(id, profile);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/profile/{key}/{id}")
    public Optional<Profile> getProfileForAdmin(@PathVariable String key,@RequestBody Profile profile, @PathVariable Long id) {
        Profile p=Authentification.getProfile(key);

        if(p!=null && p.isChief()) {
            return profileService.getProfileInfos(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

}
