package com.crocodoc.crocodocartifact.repository;

import com.crocodoc.crocodocartifact.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
