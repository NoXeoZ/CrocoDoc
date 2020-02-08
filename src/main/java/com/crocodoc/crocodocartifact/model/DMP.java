package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import java.util.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class DMP {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @OneToMany(mappedBy = "dmp")
    private List<Hospitalisation> hospitalisations;

    private String firstName;

    private String lastName;

    @Past
    private Date birthDate;

    private String birthCity;

    private int socialSecurityNumber;

    private String phoneNumber;

    @Email
    private String email;
}
