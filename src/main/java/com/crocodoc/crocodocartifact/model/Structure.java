package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "structures")
public class Structure {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_type")
    private StructureType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent")
    private Structure parent;

    @OneToOne
    @JoinColumn(name="id_user_responsible")
    private User chief;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name="structures_specialities",
            joinColumns=@JoinColumn(name="structure_id", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="speciality_ID", referencedColumnName="ID"))
    private Set<Speciality> specialities = new HashSet<>();

    @JsonManagedReference(value="valeur-hopital")
    @JsonIgnoreProperties(value = {"structure"},allowSetters = true)
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Hospitalization> hospitalizations = new ArrayList<>();
    /** JPA */
    Structure() {}

    public Structure(String name, StructureType type) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Hospitalization> getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(List<Hospitalization> hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public void setName(String name) {
        this.name = (name);
    }

    public StructureType getType() {
        return type;
    }

    public void setType(StructureType type) {
        this.type = (type);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Structure getParent() {
        return parent;
    }

    public void setParent(Structure parent) {
        if(this.equals((parent)))
            throw new IllegalArgumentException("Structure parent can't be the structure itself");
        this.parent = parent;
    }

    public User getChief() {
        return chief;
    }

    public void setChief(User chief) {
        this.chief = chief;
    }

    public List<Speciality> getSpecialities() {
        return new ArrayList<>(specialities);
    }

    public void addSpeciality(Speciality speciality) {
        specialities.add(Objects.requireNonNull(speciality));
    }

    public void removeSpeciality(Speciality speciality) {
        specialities.remove(Objects.requireNonNull(speciality));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Structure)) return false;
        Structure structure = (Structure) o;
        return getId() == structure.getId() &&
                getType() == structure.getType() &&
                getName().equals(structure.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
