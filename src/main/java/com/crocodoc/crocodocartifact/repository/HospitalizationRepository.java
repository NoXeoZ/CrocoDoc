package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {
}
