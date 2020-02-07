package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private String name ;

    public Type(){
        super();
    }

    public Type(String name){
        this.name=name;
    }


    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}