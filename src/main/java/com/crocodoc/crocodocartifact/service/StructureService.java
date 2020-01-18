package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.repository.StructureRepository;
import com.crocodoc.crocodocartifact.service.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StructureService {
    @Autowired
    private StructureRepository structureRepository;

    public Iterable<Structure>getAll(){
        return structureRepository.findAll();
    }

    public Structure create(Structure structure){

        return structureRepository.save(structure);
    }


    public Optional<Structure> getOne(Long id) {

        return Optional.ofNullable(structureRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public void delete(Long id) {

        structureRepository.deleteById(id);
    }

    public Structure update(Long id, Structure structure) {
        structureRepository.findById(id).orElseThrow(NotFoundException::new);
        structure.setId(id);
        return structureRepository.save(structure);
    }
}
