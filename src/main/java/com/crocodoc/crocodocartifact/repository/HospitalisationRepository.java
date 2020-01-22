package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Hospitalisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalisationRepository extends JpaRepository<Hospitalisation, Long> {
}
