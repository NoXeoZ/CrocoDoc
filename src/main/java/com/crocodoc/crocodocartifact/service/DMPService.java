package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.repository.ActRepository;
import com.crocodoc.crocodocartifact.repository.AssignmentRepository;
import com.crocodoc.crocodocartifact.repository.DMPRepository;
import com.crocodoc.crocodocartifact.repository.HospitalizationRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DMPService {
    @Autowired
    private DMPRepository dmpRepository;

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private ActRepository actRepository;



    public Iterable<DMP>getAllDMP(){
        return dmpRepository.findAll();
    }

    public DMP createDMP(DMP dmp){
        return dmpRepository.save(dmp);
    }

    //CHECK AUTHORIZATIONS
    public DMP updateDMP(DMP dmp){
        dmpRepository.findById(Long.valueOf(dmp.getId())).orElseThrow(NotFoundException::new);
        return dmpRepository.save(dmp);
    }

    public Optional<DMP> getDMP(Long idDmp){
        return Optional.ofNullable(dmpRepository.findById(idDmp).orElseThrow(NotFoundException::new));
    }


    public Iterable<Hospitalization>getAllHospitalizationForDMP(long dmp){
        List<Hospitalization> hospitalizations=new ArrayList<Hospitalization>();
        for(Hospitalization h: hospitalizationRepository.findAll()){
            if(h.getDMP().getId()==dmp){
                hospitalizations.add(h);
            }
        }
        return (Iterable<Hospitalization>)hospitalizations;
    }

    public Hospitalization createHospitalization(Hospitalization h){
        return hospitalizationRepository.save(h);
    }

    //CHECK AUTHORIZATIONS
    public Hospitalization updateHospitalization(Hospitalization h){
        hospitalizationRepository.findById(Long.valueOf(h.getId())).orElseThrow(NotFoundException::new);
        return hospitalizationRepository.save(h);
    }

    public Optional<Hospitalization> getHospitalization(Long idHospitalization){
        return Optional.ofNullable(hospitalizationRepository.findById(idHospitalization).orElseThrow(NotFoundException::new));
    }
    public List<Hospitalization> getAllHospitalization(){
        return hospitalizationRepository.findAll();
    }


    public Iterable<Assignment>getAllAssignmentsForHospitalization(long h){
        List<Assignment> assignments=new ArrayList<Assignment>();
        for(Assignment a: assignmentRepository.findAll()){
            if(a.getHospitalization().getId()==h){
                assignments.add(a);
            }
        }
        return (Iterable<Assignment>)assignments;
    }

    public Assignment createAssignment(Assignment a){
        return assignmentRepository.save(a);
    }

    //CHECK AUTHORIZATIONS
    public Assignment updateAssignment(Assignment a){
        assignmentRepository.findById(Long.valueOf(a.getId())).orElseThrow(NotFoundException::new);
        return assignmentRepository.save(a);
    }

    public Optional<Assignment> getAssignment(Long idAssignment){
        return Optional.ofNullable(assignmentRepository.findById(idAssignment).orElseThrow(NotFoundException::new));
    }


    public Iterable<Act>getAllActsForAssignment(long a){
        List<Act> acts=new ArrayList<Act>();
        for(Act act: actRepository.findAll()){
            if(act.getAssignment().getId()== a){
                acts.add(act);
            }
        }
        return (Iterable<Act>)acts;
    }

    public Act createAct(Act a){
        return actRepository.save(a);
    }

    //CHECK AUTHORIZATIONS
    public Act updateAct(Act a){
        actRepository.findById(Long.valueOf(a.getId())).orElseThrow(NotFoundException::new);
        return actRepository.save(a);
    }

    public Optional<Act> getAct(Long idAct){
        return Optional.ofNullable(actRepository.findById(idAct).orElseThrow(NotFoundException::new));
    }

    public Iterable<Act>getSpecificActForAssignment(long a, ActType at){
        List<Act> acts=new ArrayList<Act>();
        for(Act act: actRepository.findAll()){
            if(act.getAssignment().getId()== a && act.getType().equals(at)){
                acts.add(act);
            }
        }
        return (Iterable<Act>)acts;
    }
}
