package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;

import java.util.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class DMP {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @OneToMany(mappedBy = "dmp")
    private List<Hospitalisation> hospitalisations;
}
