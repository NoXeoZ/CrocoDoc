package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dmp")
public class DMP {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "birth", nullable = false)
    private Date birth;
    @Column(name = "birth_city", nullable = false)
    private String birthCity;
    @Column(name = "social_security_number", nullable = false)
    private int socialSecurityNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "dmp", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Hospitalization> hospitalizations = new ArrayList<>();


    /** Juste for JPA */
    protected DMP() {}

    public DMP(String firstname, String lastname, Date birth, String birthCity, int socialSecurityNumber, String phoneNumber, String email) {
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
        this.birth = Objects.requireNonNull(birth);
        this.birthCity = Objects.requireNonNull(birthCity);
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber; // can be null
        this.email = email; // can be null
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = Objects.requireNonNull(firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = Objects.requireNonNull(lastname);
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = Objects.requireNonNull(birth);
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = Objects.requireNonNull(birthCity);
    }

    public int getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(int socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email);
    }

    public List<Hospitalization> getHospitalization() {
        return new ArrayList<>(hospitalizations);
    }

    public void addHospitalization(Hospitalization o) {
        hospitalizations.add(Objects.requireNonNull(o));
    }
}
