package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Hospitalisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {
}
