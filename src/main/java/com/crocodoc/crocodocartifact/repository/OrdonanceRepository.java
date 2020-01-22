package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Ordonance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdonanceRepository extends JpaRepository<Ordonance, Long> {
}
