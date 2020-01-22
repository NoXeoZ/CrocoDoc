package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.DMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DMPRepository extends JpaRepository<DMP, Long> {
}
