package com.crocodoc.crocodocartifact.resource;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.service.DMPService;
import com.crocodoc.crocodocartifact.service.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DMPResource {
    @Autowired
    private DMPService dmpService;
    @Autowired
    private StructureService structureService;
    @Autowired
    private com.crocodoc.crocodocartifact.service.UserService UserService;

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

    @PostMapping("/dmp/hospitalization/create/{key}/{idDmp}/{idStructure}")
    public Hospitalization createHospitalization(@PathVariable String key, @RequestBody Hospitalization h, @PathVariable long idDmp, @PathVariable long idStructure) {
        User p= Authentification.getUser(key);
        Optional<DMP>dmp=dmpService.getDMP(idDmp);
        Optional<Structure>structure=structureService.getOne(idStructure);
        h.setDmp(dmp.get());
        h.setHospital(structure.get());
        if(p!=null) {
            return dmpService.createHospitalization(h);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/{key}")
    public List<Hospitalization> getAllHospitalization(@PathVariable String key) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAllHospitalization();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/hospitalizationDMP/{key}/{idHospitalization}")
    public DMP getDmpOfHospitalization(@PathVariable String key, @PathVariable long idHospitalization) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getHospitalization(idHospitalization).get().getDMP();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/hospitalizationStruct/{key}/{idHospitalization}")
    public Structure getStructOfHospitalization(@PathVariable String key, @PathVariable long idHospitalization) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getHospitalization(idHospitalization).get().getHospital();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }

    @GetMapping("/dmp/hospitalization/{key}/{id}")
    public Optional<Hospitalization> getHospitalization(@PathVariable String key, @PathVariable long id) {
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
    public Assignment createHospitalization(@PathVariable String key, @RequestBody Assignment a) {
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
        Iterable<Act> acts= dmpService.getAllActsForAssignment(id);
        acts.forEach(act -> System.out.println(act.getImage()));
        if (p != null) {
            return dmpService.getAllActsForAssignment(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "  key  " + key + " not found");
        }
    }

    @PostMapping("/dmp/hospitalization/assignment/act/create/{key}/{idAssignement}/{idUser}")
    public Act createAct(@PathVariable String key, @RequestBody Act a, @PathVariable long idAssignement, @PathVariable long idUser) {
        User p = Authentification.getUser(key);
        Optional<Assignment> assignment=dmpService.getAssignment(idAssignement);
        Optional<User> user=UserService.getUser(idUser);
        a.setDraft(false);
        a.setUser(user.get());
        a.setAssignment(assignment.get());
        a.setDraft(true);
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

    @GetMapping("/dmp/hospitalization/assignment/act/user/{key}/{id}")
    public User getUserAct(@PathVariable String key, @PathVariable long id) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            return dmpService.getAct(id).get().getUser();
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


    @GetMapping("/dmp/search/{key}/{name}")
    public List<DMP> searchDMP(@PathVariable String key, @PathVariable String name) {
        User p= Authentification.getUser(key);
        if(p!=null) {
            Iterable<DMP>dmps = dmpService.getAllDMP();
            List<DMP>dmpList=new ArrayList<DMP>();
            dmps.forEach(u->{if(u.getFirstname().toLowerCase().contains(name.toLowerCase()) ||
                    u.getLastname().toLowerCase().contains(name.toLowerCase()) ||
                    u.getBirthCity().toLowerCase().contains(name.toLowerCase()) ||
                    u.getSocialSecurityNumber().toLowerCase().contains(name.toLowerCase()))dmpList.add(u);});
            return dmpList;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"  key  "+  key  +  " not found");
        }
    }
}
