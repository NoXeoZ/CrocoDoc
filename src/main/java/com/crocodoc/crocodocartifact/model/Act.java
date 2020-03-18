package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "acts")
public class Act {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "creation_date", nullable = false)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date createdAt;
    @Column(name = "draft", nullable = false)
    private boolean draft = true;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", nullable = false)
    private ActType type;

    @Lob
    @Column(name = "images")
    @Basic(fetch = FetchType.LAZY)
    private HashMap<String, byte[]> images= new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "id_assignment", nullable = false)
    @JsonBackReference
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    /** JPA */
    Act() {}

    public Act(User user, ActType type, Assignment assignment, String description) {
        this.user = Objects.requireNonNull(user);
        this.type = Objects.requireNonNull(type);
        this.assignment = Objects.requireNonNull(assignment);
        this.description = Objects.requireNonNull(description);
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");
        this.description = Objects.requireNonNull(description);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public ActType getType() {
        return type;
    }

    public void setType(ActType type) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");
        this.type = Objects.requireNonNull(type);
    }

    public boolean isDraft() {
        return draft;
    }

    public void validate() {
        if(!draft)
            throw new IllegalStateException("The act has already been validate.");
        draft = false;
        createdAt = new Date();
    }

    public void addImage(String title, byte[] image) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");

        if(images.containsKey(Objects.requireNonNull(title)))
            throw new IllegalArgumentException("The title of the image is already present in the act's list of image. Please change the title.");

        images.put(title, Objects.requireNonNull(image));
    }

    public void removeImage(String title) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");

        if(!images.containsKey(Objects.requireNonNull(title)))
            throw new IllegalArgumentException("The image is not in the list.");

        images.remove(title);
    }

    public byte[] getImage(String title) {
        if(!images.containsKey(Objects.requireNonNull(title)))
            throw new IllegalArgumentException("The image is not in the list.");

        return images.get(title);
    }

    public Set<String> getImagesTitles() {
        return images.keySet();
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");
        this.assignment = Objects.requireNonNull(assignment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");
        this.user = Objects.requireNonNull(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Act act = (Act) o;

        if (id != act.id) return false;
        if (draft != act.draft) return false;
        if (!description.equals(act.description)) return false;
        if (!createdAt.equals(act.createdAt)) return false;
        return type == act.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, user, assignment);
    }
}
