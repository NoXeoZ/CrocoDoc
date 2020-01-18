package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dmp")
public class DMP {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "dmp", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Hospitalisation> hospitalisations = new ArrayList<>();

    @OneToMany(mappedBy = "dmp", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Acte> actes = new ArrayList<>();


    /** Juste for JPA */
    protected DMP() {}

    public DMP(User user) {
        this.user = Objects.requireNonNull(user);
    }

    public User getUser() {
        return user;
    }

    public List<Hospitalisation> getHospitalisations() {
        return new ArrayList<>(hospitalisations);
    }

    public boolean addHospitalisation(Hospitalisation o) {
        hospitalisations.add(o);
        return true;
    }

    public List<Acte> getActes() {
        return new ArrayList<>(actes);
    }

    public boolean addActe(Acte o) {
        actes.add(o);
        return true;
    }
}
