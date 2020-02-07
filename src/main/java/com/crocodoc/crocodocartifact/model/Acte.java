package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


import static javax.persistence.GenerationType.AUTO;

@Entity
public class Acte implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private Date date;
    private Type type;
    private String path;

    public Acte(Date date, Type type,String path){
        this.date=date;
        this.type=type;
        this.path=path;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

}
