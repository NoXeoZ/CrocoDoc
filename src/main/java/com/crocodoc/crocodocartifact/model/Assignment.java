package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "id_service", nullable = false)
    private Structure service;

    @ManyToOne
    @JoinColumn(name = "id_hospitalization")
    @JsonBackReference
    private Hospitalization hospitalization;

    @OneToMany(mappedBy = "assignment", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Act> acts = new ArrayList<>();

    /** Just for JPA */
    protected Assignment() { }

    public Assignment(Structure service) {
        this.service = Objects.requireNonNull(service);
        startDate = LocalDateTime.now();
    }

    public Assignment(Structure service, LocalDateTime startDate, LocalDateTime endDate) {
        this.service = Objects.requireNonNull(service);
        this.startDate = Objects.requireNonNull(startDate);
        this.endDate = Objects.requireNonNull(endDate);
    }

    public Long getId() {
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

    public Structure getService() {
        return service;
    }

    public void setService(Structure service) {
        this.service = Objects.requireNonNull(service);
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = Objects.requireNonNull(hospitalization);
    }

    public List<Act> getActs() {
        return new ArrayList<>(acts); // defensive copy
    }

    public void addActs(Act... acts) {
        for(Act a : Objects.requireNonNull(acts)) {
            this.acts.add(a);
            a.setAssignment(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Assignment)) return false;
        return Objects.equals(id, ((Assignment) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, service);
    }

    @Override
    /* TODO : see why it is here, remove this useless function */
    public String toString() {
        return "Affectation{" +
                "id=" + id +
                ", dateDebut=" + startDate +
                ", dateFin=" + endDate +
                ", service=" + service +
                '}';
    }
}
