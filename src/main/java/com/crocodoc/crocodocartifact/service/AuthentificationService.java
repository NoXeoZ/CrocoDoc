package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthentificationService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(String login, String password) {
        Iterable<User> users=userRepository.findAll();
        for(User p:users){
            if(p.getEmail().equals(login) && p.getPassword().equals(password)){
                return Optional.of(p);
            }
        }
        return Optional.empty();//Optional.ofNullable(userRepository.findByLoginAngPassword(login, password).orElseThrow(NotFoundException::new));

    }

    public Optional<User> getUserFromMail(String mail) {
        Iterable<User> users=userRepository.findAll();
        for(User p:users){
            if(p.getEmail().equals(mail)){
                return Optional.of(p);
            }
        }
        return Optional.empty();
        //return Optional.ofNullable(userRepository.findByMail(mail).orElseThrow(NotFoundException::new));

    }
}
