package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.DMP;
import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.repository.DMPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DMPService {
    @Autowired
    private DMPRepository dmpRepository;

    public void create(DMP dmp){
        dmpRepository.save(dmp);
    }

    public void update(DMP dmp){
        dmpRepository.save(dmp);
    }

    public void delete(User user, long id) {
        // TODO : check user right before delete
        dmpRepository.deleteById(id);
    }

    public Optional<DMP> get(long id) {
        return dmpRepository.findById(id);
    }

}
