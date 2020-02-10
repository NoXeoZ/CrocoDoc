package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "structures")
public class Structure {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "id_type", nullable = false)
    private StructureType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent", nullable = false)
    private Structure parent;

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

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public StructureType getType() {
        return type;
    }

    public void setType(StructureType type) {
        this.type = Objects.requireNonNull(type);
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
        if(this.equals(Objects.requireNonNull(parent)))
            throw new IllegalArgumentException("Structure parent can't be the structure itself");
        this.parent = parent;
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
