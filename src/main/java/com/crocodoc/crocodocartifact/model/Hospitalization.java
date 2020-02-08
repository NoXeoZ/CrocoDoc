package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hospitalizations")
public class Hospitalization implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "id_hospital", nullable = false)
    private Structure hospital;

    @ManyToOne
    @JoinColumn(name = "id_dmp", nullable = false)
    @JsonBackReference
    private DMP dmp;

    @OneToMany(mappedBy = "hospitalization", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Assignment> assignments = new ArrayList<>();

    /** Just for JPA */
    protected Hospitalization() { }

    public Hospitalization(Structure hospital, DMP dmp) {
        this.hospital = Objects.requireNonNull(hospital);
        this.dmp = Objects.requireNonNull(dmp);
        startDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = Objects.requireNonNull(startDate);
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = Objects.requireNonNull(endDate);
    }

    public void finish() {
        endDate = LocalDateTime.now();
    }

    public Structure getHospital() {
        return hospital;
    }

    public DMP getDMP() {
        return dmp;
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments); // defensive copy
    }

    public void addAssignments(Assignment... assignments) {
        for(Assignment a : Objects.requireNonNull(assignments)) {
            this.assignments.add(a);
            a.setHospitalization(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hospitalization)) return false;
        return Objects.equals(id, ((Hospitalization) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, hospital, dmp);
    }
}