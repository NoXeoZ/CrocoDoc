package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.User;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StructureService {
    @Autowired
    private StructureRepository structureRepository;

    public Structure create(Structure structure) {
        return structureRepository.save(structure);
    }

    public Structure update(Structure structure) {
        structureRepository.findById(structure.getId()).orElseThrow(NotFoundException::new);
        User chef =  structureRepository.findById(structure.getId()).get().getChief();
        structure.setChief(chef);
        return structureRepository.save(structure);
    }

    public void delete(Long id) {
        structureRepository.deleteById(id);
    }

    public Optional<Structure> getOne(Long id) {
        return Optional.ofNullable(structureRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public List<Structure> getAll(){
        return structureRepository.findAll();
    }

    public List<Structure> getAllByParentId(long id) {
        structureRepository.findById(id).orElseThrow(NotFoundException::new); // check id
        return structureRepository.findAllByParentId(id);
    }
    public Structure setChief(Optional<Structure> s, Optional<User> profil){
        Structure structure=s.get();
        structure.setChief(profil.get());
        return structureRepository.save(structure);
    }

    public Structure setParent(Optional<Structure> s, Optional<Structure> parent) {
        Structure structure=s.get();
        structure.setParent(parent.get());
        return structureRepository.save(structure);
    }
}
