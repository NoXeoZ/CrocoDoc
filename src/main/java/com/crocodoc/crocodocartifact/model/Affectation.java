package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Affectation {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private Boolean endEffectation;
    @ManyToOne
    private Structure structure;

    public Affectation() {
    }
    public Affectation(Date dateDebut,Date dateFin) {
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
    }

    public Affectation(Date dateDebut,Date dateFin,Structure structure) {
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.structure=structure;
    }

    public Affectation(Structure structure) {
        this.structure=structure;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getEndEffectation() {
        return endEffectation;
    }

    public void setEndEffectation(Boolean endEffectation) {
        this.endEffectation = endEffectation;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Affectation)) return false;
        Affectation that = (Affectation) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDateDebut(), that.getDateDebut()) &&
                Objects.equals(getDateFin(), that.getDateFin()) &&
                Objects.equals(getEndEffectation(), that.getEndEffectation()) &&
                Objects.equals(getStructure(), that.getStructure());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateDebut(), getDateFin(), getEndEffectation(), getStructure());
    }

    @Override
    public String toString() {
        return "Affectation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", endEffectation=" + endEffectation +
                ", structure=" + structure +
                '}';
    }
}
