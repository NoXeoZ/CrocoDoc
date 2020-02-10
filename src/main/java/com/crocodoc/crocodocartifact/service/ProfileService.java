package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.repository.ProfileRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Iterable<Profile>getAll(){
        return profileRepository.findAll();
    }

    public Profile create(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long idProfile){
        profileRepository.deleteById(idProfile);
    }

    public Profile updateProfile(Profile p){
        profileRepository.findById(Long.valueOf(p.getId())).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        //profile.setId(p.getId());
        return profileRepository.save(p);
    }

    public Optional<Profile> getProfile(Long idUser){
        return Optional.ofNullable(profileRepository.findById(idUser).orElseThrow(NotFoundException::new));
    }

    public Profile updateProfileForAdmin(Long p,Profile profile){
        profileRepository.findById(Long.valueOf(p)).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        //profile.setId(p);
        return profileRepository.save(profile);
    }
}
