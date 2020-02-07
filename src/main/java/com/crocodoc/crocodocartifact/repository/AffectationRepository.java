package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Affectation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository  extends CrudRepository<Affectation,Long> {

}
