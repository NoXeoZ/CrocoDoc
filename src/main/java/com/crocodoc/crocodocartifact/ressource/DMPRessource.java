package com.crocodoc.crocodocartifact.ressource;

import com.crocodoc.crocodocartifact.model.DMP;
import com.crocodoc.crocodocartifact.service.DMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class DMPRessource {
    @Autowired
    private DMPService dmpService;

    @GetMapping("/dmp/{id}")
    public Optional<DMP> get(@PathVariable long id) {
        return dmpService.get(id);
    }
}
