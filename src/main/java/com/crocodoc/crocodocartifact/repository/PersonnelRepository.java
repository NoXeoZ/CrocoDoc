package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
