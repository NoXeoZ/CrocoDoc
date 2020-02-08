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

    @OneToMany(mappedBy = "dmp", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Hospitalisation> hospitalisations = new ArrayList<>();

    @OneToMany(mappedBy = "dmp", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Act> actes = new ArrayList<>();


    /** Juste for JPA */
    protected DMP() {}


    public List<Hospitalisation> getHospitalisations() {
        return new ArrayList<>(hospitalisations);
    }

    public void addHospitalisation(Hospitalisation o) {
        hospitalisations.add(Objects.requireNonNull(o));
    }

    public List<Act> getActes() {
        return new ArrayList<>(actes);
    }

    public void addActe(Act o) {
        actes.add(Objects.requireNonNull(o));
    }
}
