package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String state;
}
