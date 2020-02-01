package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
}
