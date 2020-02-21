package com.crocodoc.crocodocartifact.resource;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.service.DMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class DMPResource {
    @Autowired
    private DMPService dmpService;

    @GetMapping("/dmps/{key}")
    public Iterable<DMP> getAllDMP(@PathVariable String key) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAllDMP();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/create/{key}")
    public DMP createDMP(@PathVariable String key, @RequestBody DMP dmp) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.createDMP(dmp);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/{key}/{id}")
    public Optional<DMP> getOneDMP(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getDMP(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/update/{key}")
    public DMP updateDMP(@PathVariable String key,@RequestBody DMP dmp) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.updateDMP(dmp);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }

    @GetMapping("/dmp/hospitalizations/{key}/{id}")
    public Iterable<Hospitalization> getAllHospitalizationForDMP(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAllHospitalizationForDMP(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/create/{key}")
    public Hospitalization createAssignment(@PathVariable String key, @RequestBody Hospitalization h) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.createHospitalization(h);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/{key}/{id}")
    public Optional<Hospitalization> getOneHospitalization(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getHospitalization(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/update/{key}")
    public Hospitalization updateHospitaization(@PathVariable String key,@RequestBody Hospitalization h) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.updateHospitalization(h);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/assignments/{key}/{id}")
    public Iterable<Assignment> getAllAssignmentsForHospitalization(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAllAssignmentsForHospitalization(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/assignment/create/{key}")
    public Assignment createAssignment(@PathVariable String key, @RequestBody Assignment a) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.createAssignment(a);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/assignment/{key}/{id}")
    public Optional<Assignment> getOneAssignment(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAssignment(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/assignment/update/{key}")
    public Assignment updateAssignment(@PathVariable String key,@RequestBody Assignment a) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.updateAssignment(a);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }


    @GetMapping("/dmp/hospitalization/assignment/acts/{key}/{id}")
    public Iterable<Act> getAllActsForAssignment(@PathVariable String key, @PathVariable long id) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.getAllActsForAssignment(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/assignment/act/create/{key}")
    public Act createAct(@PathVariable String key, @RequestBody Act a) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.createAct(a);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/assignment/act/{key}/{id}")
    public Optional<Act> getOneAct(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAct(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/assignment/act/update/{key}")
    public Act updateAct(@PathVariable String key,@RequestBody Act a) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.updateAct(a);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/assignment/act/{key}/{id}/{at}")
    public Iterable<Act> getSpecificActForAssignment(@PathVariable String key, @PathVariable long id, @PathVariable ActType at) {
        User p = Authentification.getUser(key);
        if (p != null) {
            return dmpService.getSpecificActForAssignment(id, at);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }
}
