package com.example.demo.insurance;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "insurance",indexes = {@Index(name = "insurance_pkey",columnList = "id",unique = true)})
public class Insurance {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private Date starting;

    @Column
    private Date ending;

    @Column
    private float price;

    public Insurance(int id, String name, Date starting, Date ending, float price) {
        this.id = id;
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
    }

    public Insurance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
