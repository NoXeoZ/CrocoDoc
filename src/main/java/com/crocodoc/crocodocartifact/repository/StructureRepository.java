package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Structure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureRepository  extends CrudRepository<Structure,Long> {
}
