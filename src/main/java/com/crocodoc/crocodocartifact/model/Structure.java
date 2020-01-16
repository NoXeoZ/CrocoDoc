package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Structure {
    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @NotEmpty
    private String name;
    private int role;

    public Structure(long id, String name, int role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Structure() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Structure)) return false;
        Structure structure = (Structure) o;
        return getId() == structure.getId() &&
                getRole() == structure.getRole() &&
                getName().equals(structure.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRole());
    }

    @Override
    public String toString() {
        return "structure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
