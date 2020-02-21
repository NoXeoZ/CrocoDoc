package com.crocodoc.crocodocartifact.service;

import com.crocodoc.crocodocartifact.model.Structure;
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
}
