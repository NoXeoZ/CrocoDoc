package com.crocodoc.crocodocartifact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Hospitalisation implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private DMP dmp;

    public Hospitalisation(){
        super();
    }
    public Hospitalisation(Date endDate, Date startEnd){
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
