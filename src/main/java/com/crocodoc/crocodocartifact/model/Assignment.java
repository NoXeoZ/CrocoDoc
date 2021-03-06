package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.*;
import java.sql.Timestamp;
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
    @Column(name = "start_date")
    /*@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")*/
    private Date startDate;

    @Column(name = "end_date")
    /*@JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")*/
    private Date endDate;

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

    public Assignment(Structure service, Hospitalization hospitalization) {
        this.service = Objects.requireNonNull(service);
        this.hospitalization = Objects.requireNonNull(hospitalization);
        startDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public Assignment(Structure service, Hospitalization hospitalization, LocalDateTime startDate, LocalDateTime endDate) {
        this.service = Objects.requireNonNull(service);
        this.hospitalization = Objects.requireNonNull(hospitalization);
        this.startDate = Timestamp.valueOf(Objects.requireNonNull(startDate));
        this.endDate = Timestamp.valueOf(Objects.requireNonNull(endDate));
    }

    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return (endDate != null ) ? endDate : null;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void finish() {
        endDate = new Date();
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

    public void addAct(Act act) {
        this.acts.add(Objects.requireNonNull(act));
        act.setAssignment(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assignment that = (Assignment) o;

        if (id != that.id) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (!service.equals(that.service)) return false;
        return hospitalization.equals(that.hospitalization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, service);
    }
}
