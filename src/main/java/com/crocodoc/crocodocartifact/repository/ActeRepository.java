package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Acte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeRepository extends JpaRepository<Acte,Long> {
}
