package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.repository.ProfileRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    public Iterable<Profile>getAll(){
        return profileRepository.findAll();
    }

    public Profile create(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfile(Integer idProfile){
        profileRepository.deleteById(Long.valueOf(idProfile));
    }

    /* demander a Thomas le fonctionnement des clefs de connexions
    public boolean updateProfile(String key, Map<String,String>){

    }*/

    public Optional<Profile> getProfileInfosForAdmin(Integer idUser){
        return profileRepository.findById(Long.valueOf(idUser)).orElseThrow(NotFoundException::new);
    }

    public Profile updateProfileForAdmin(Integer idProfile,Profile profile){
        profileRepository.findById(Long.valueOf(idProfile)).orElseThrow(NotFoundException::new);
        profile.setId(Long.valueOf(idProfile));
        return profileRepository.save(profile);
    }
}
