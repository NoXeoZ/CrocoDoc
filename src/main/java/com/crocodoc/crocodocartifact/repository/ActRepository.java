package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRepository extends JpaRepository<Act,Long> {
}
