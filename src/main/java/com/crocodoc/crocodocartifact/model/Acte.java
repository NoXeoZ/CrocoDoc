package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="Acte")
public class Acte implements Serializable{

    private long id;
    private Date date;
    private Type type;
    private String path;

    public Acte(Date date, Type type,String path){
        this.date=date;
        this.type=type;
        this.path=path;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name="ACTE_ID")
    public long getId() {
        return id;
    }

    @Column(name="ACTE_DATE")
    public Date getDate() {
        return date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID", nullable = false)
    public Type getType() {
        return type;
    }

    @Column(name = "ACTE_PATH")
    public String getPath() {
        return path;
    }

}