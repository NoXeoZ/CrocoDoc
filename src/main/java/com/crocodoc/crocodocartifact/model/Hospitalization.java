package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
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
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Timestamp endDate;

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
        startDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate.toLocalDateTime();
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate =  Timestamp.valueOf(Objects.requireNonNull(startDate));
    }

    public LocalDateTime getEndDate() {
        return (endDate != null) ? endDate.toLocalDateTime() : null;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate =  Timestamp.valueOf(Objects.requireNonNull(endDate));
    }

    public void finish() {
        endDate =  Timestamp.valueOf(LocalDateTime.now());
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

    public void addAssignment(Assignment assignment) {
        this.assignments.add(Objects.requireNonNull(assignment));
        assignment.setHospitalization(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospitalization that = (Hospitalization) o;

        if (id != that.id) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (!hospital.equals(that.hospital)) return false;
        return dmp.equals(that.dmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, hospital, dmp);
    }
}
