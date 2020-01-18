package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="Type")
public class Type implements Serializable{

    private long id;
    private String name ;

    public Type(String path){
        this.path=path;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name="TYPE_ID")
    public long getId() {
        return id;
    }


    @Column(name = "TYPE_NAME")
    public String getPath() {
        return path;
    }

}