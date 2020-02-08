package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "draft", nullable = false)
    private boolean draft = true;
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

    protected  Act() {}

    public Act(String description, ActType type) {
        this.description = Objects.requireNonNull(description);
        this.type = Objects.requireNonNull(type);
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

    public LocalDateTime getCreatedAt() {
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

    public void validate() {
        if(!draft)
            throw new IllegalStateException("The act has already been validate.");
        draft = false;
        createdAt = LocalDateTime.now();
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
}
