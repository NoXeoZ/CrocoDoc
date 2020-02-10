package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Structure;
import com.crocodoc.crocodocartifact.model.StructureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructureRepository extends JpaRepository<Structure,Long> {
    List<Structure> findAllByParentId(long id);
    List<Structure> findAllByType(StructureType type);
}
