package com.crocodoc.crocodocartifact.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "specialities")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;

    Speciality() {}

    public Speciality(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public Speciality(String name, String description) {
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = (description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speciality that = (Speciality) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
