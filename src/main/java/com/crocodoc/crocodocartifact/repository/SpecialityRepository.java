package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
