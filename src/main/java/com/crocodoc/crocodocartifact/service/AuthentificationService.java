package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Profile;
import com.crocodoc.crocodocartifact.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthentificationService {

    @Autowired
    private ProfileRepository profileRepository;

    public Optional<Profile> getProfile(String login, String password) {
        Iterable<Profile> profiles=profileRepository.findAll();
        for(Profile p:profiles){
            if(p.checkConnexion(login, password)){
                return Optional.of(p);
            }
        }
        return Optional.empty();//Optional.ofNullable(profileRepository.findByLoginAngPassword(login, password).orElseThrow(NotFoundException::new));

    }

    public Optional<Profile> getProfileFromMail(String mail) {
        Iterable<Profile> profiles=profileRepository.findAll();
        for(Profile p:profiles){
            if(p.getMail().equals(mail)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
        //return Optional.ofNullable(profileRepository.findByMail(mail).orElseThrow(NotFoundException::new));

    }
}
