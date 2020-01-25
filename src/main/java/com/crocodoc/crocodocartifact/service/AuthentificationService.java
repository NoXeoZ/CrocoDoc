package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AuthentificationService {

    @Autowired
    private ProfileRepository profileRepository;

    public Optional<Profile> getProfile(String login, String password) {

        return Optional.ofNullable(profileRepository.findByLoginAngPassword(login, password).orElseThrow(NotFoundException::new));

    }

    public Optional<Profile> getProfileFromMail(String mail) {

        return Optional.ofNullable(profileRepository.findByMail(mail).orElseThrow(NotFoundException::new));

    }
}
