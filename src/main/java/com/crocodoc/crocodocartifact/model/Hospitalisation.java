package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Hospitalisation {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @ManyToOne
    private DMP dmp;

    public Hospitalisation() {

    }

    public Hospitalisation(DMP dmp) {
        this.dmp = dmp;
    }
}
