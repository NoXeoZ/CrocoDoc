package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Affectation {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
}
