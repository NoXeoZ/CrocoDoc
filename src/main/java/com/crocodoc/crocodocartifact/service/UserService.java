package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.repository.UserRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository profileRepository;

    public Iterable<User>getAll(){
        return profileRepository.findAll();
    }

    public User create(User profile){
        return profileRepository.save(profile);
    }

    public void deleteUser(Long idUser){
        profileRepository.deleteById(idUser);
    }

    public User updateUser(User p){
        profileRepository.findById(Long.valueOf(p.getId())).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        //profile.setId(p.getId());
        return profileRepository.save(p);
    }

    public Optional<User> getUser(Long idUser){
        return Optional.ofNullable(profileRepository.findById(idUser).orElseThrow(NotFoundException::new));
    }

    public User updateUserForAdmin(Long p,User profile){
        profileRepository.findById(Long.valueOf(p)).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        //profile.setId(p);
        return profileRepository.save(profile);
    }
}
