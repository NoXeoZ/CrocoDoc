package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hospitalizations")
public class Hospitalization implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @JsonBackReference(value="valeur-hopital")
    @ManyToOne
    @JsonIgnoreProperties(value = {"hospitalization"},allowSetters = true)
    private Structure hospital;

    @JsonBackReference(value="valeur-dmp")
    @ManyToOne
    @JsonIgnoreProperties(value = {"hospitalization"},allowSetters = true)
    private DMP dmp;

    @OneToMany(mappedBy = "hospitalization", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Assignment> assignments = new ArrayList<>();

    /** Just for JPA */
    protected Hospitalization() { }

    public Hospitalization(Structure hospital, DMP dmp) {
        this.hospital = Objects.requireNonNull(hospital);
        this.dmp = Objects.requireNonNull(dmp);
        startDate = new Date();
    }

    public long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = (startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = (endDate);
    }

    public void finish() {
        endDate = new Date();
    }

    public Structure getHospital() {
        return hospital;
    }

    public DMP getDMP() {
        return dmp;
    }

    public void setHospital(Structure hospital) {
        this.hospital = hospital;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments); // defensive copy
    }

    public void addAssignment(Assignment assignment) {
        this.assignments.add((assignment));
        assignment.setHospitalization(this);
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hospital=" + hospital +
                ", dmp=" + dmp +
                ", assignments=" + assignments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospitalization that = (Hospitalization) o;

        if (id != that.id) return false;
        if (!startDate.equals(that.startDate)) return false;
        //     if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (!hospital.equals(that.hospital)) return false;
        return dmp.equals(that.dmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, hospital, dmp);
    }

    public void setAssignments(List<Assignment> lst) {
        this.assignments = lst;
    }
}
