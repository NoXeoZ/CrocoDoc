package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.repository.UserRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long idUser){
        userRepository.deleteById(idUser);
    }

    public User updateUser(User p){
        userRepository.findById(Long.valueOf(p.getId())).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        //user.setId(p.getId());
        return userRepository.save(p);
    }

    public Optional<User> getUser(Long idUser){
        return Optional.ofNullable(userRepository.findById(idUser).orElseThrow(NotFoundException::new));
    }

    public User updateUserForAdmin(Long p,User user){
        userRepository.findById(Long.valueOf(p)).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        //user.setId(p);
        return userRepository.save(user);
    }
}
