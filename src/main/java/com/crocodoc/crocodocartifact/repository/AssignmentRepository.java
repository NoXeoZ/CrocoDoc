package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository  extends CrudRepository<Assignment,Long> {

}
