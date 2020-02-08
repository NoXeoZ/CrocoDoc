package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "hospitalization")
public class Hospitalization implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date", nullable =  false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "id_hospital", nullable = false)
    private Structure hospital;

    @ManyToOne
    @JoinColumn(name = "id_dmp", nullable = false)
    @JsonBackReference
    private DMP dmp;

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

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Structure getHospital() {
        return hospital;
    }

    public DMP getDMP() {
        return dmp;
    }

    public void finish() {
        endDate = LocalDateTime.now();
    }
}
