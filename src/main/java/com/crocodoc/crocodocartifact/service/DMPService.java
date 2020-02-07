package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.*;
import com.crocodoc.crocodocartifact.repository.ActeRepository;
import com.crocodoc.crocodocartifact.repository.AffectationRepository;
import com.crocodoc.crocodocartifact.repository.DMPRepository;
import com.crocodoc.crocodocartifact.repository.HospitalisationRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DMPService {
    @Autowired
    private DMPRepository dmpRepository;

    @Autowired
    private ActeRepository acteRepository;

    @Autowired
    private HospitalisationRepository hospitalisationRepository;

    @Autowired
    private AffectationRepository affectationRepository;

    public Iterable<Affectation>getAllAffectation(long idDmp){
        Optional<DMP> dmp=Optional.ofNullable(dmpRepository.findById(idDmp).orElseThrow(NotFoundException::new));
        return affectationRepository.findAll();
    }

    public Iterable<Acte>getAllActe(long idActe){
        return acteRepository.findAll();
    }

    public Iterable<Hospitalisation>getAllHospitalisation(long idHospitalisation){
        return hospitalisationRepository.findAll();
    }

    public Iterable<DMP>getAll(){
        return dmpRepository.findAll();
    }

    /*public Profile create(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long idProfile){
        profileRepository.deleteById(idProfile);
    }

    public Profile updateProfile(Profile p,Profile profile){
        profileRepository.findById(Long.valueOf(p.getId())).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        profile.setId(p.getId());
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileInfos(Long idUser){
        return Optional.ofNullable(profileRepository.findById(idUser).orElseThrow(NotFoundException::new));
    }

    public Profile updateProfileForAdmin(Long p,Profile profile){
        profileRepository.findById(Long.valueOf(p)).orElseThrow(NotFoundException::new);
        //AUTOSET UNMODIFIABLE FIELDS
        profile.setId(p);
        return profileRepository.save(profile);
    }*/
}
