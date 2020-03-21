package com.crocodoc.crocodocartifact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Date createdAt;
    @Column(name = "draft", nullable = false)
    private boolean draft = true;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type", nullable = false)
    private ActType type;

    @Lob
    @Column(name = "images")
    @Basic(fetch = FetchType.EAGER)
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_assignment", nullable = false)
    @JsonBackReference
    @JsonIgnoreProperties(value = {"acts"},allowSetters = true)

    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
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
            throw new IllegalStateException("The act has been validatljljle and can no longer be modify.");
        this.description = Objects.requireNonNull(description);
    }

    public Date getCreatedAt() {
        return (createdAt != null) ? createdAt : null;
    }

    public ActType getType() {
        return type;
    }

    public void setType(ActType type) {
        this.type = Objects.requireNonNull(type);
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft){
        this.draft = draft;
    }

    public void validate() {
        if(!draft)
            throw new IllegalStateException("The act has already been validate.");
        draft = false;
        createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public void addImage(String title, String image) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");

        //if(images.containsKey(Objects.requireNonNull(title)))
          //  throw new IllegalArgumentException("The title of the image is already present in the act's list of image. Please change the title.");

        //images.put(title, Objects.requireNonNull(image));
        this.image = Objects.requireNonNull(image);
    }

    public void removeImage(String title) {
        if(!draft)
            throw new IllegalStateException("The act has been validate and can no longer be modify.");

        //if(!images.containsKey(Objects.requireNonNull(title)))
          //  throw new IllegalArgumentException("The image is not in the list.");

        image = null;//images.remove(title);
    }

    public String getImage() {
        //if(!images.containsKey(Objects.requireNonNull(title)))
          //  throw new IllegalArgumentException("The image is not in the list.");

        return image;//.get(title);
    }

    /*public Set<String> getImagesTitles() {
        return images.keySet();
    }*/

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = (assignment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = (user);
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

    @Override
    public String toString() {
        return "Act{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", draft=" + draft +
                ", type=" + type +
                ", images=" + image +
                ", assignment=" + assignment +
                ", user=" + user +
                '}';
    }
}
