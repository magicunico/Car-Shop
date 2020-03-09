package com.example.demo.insurance;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "insurance",indexes = {@Index(name = "insurance_pkey",columnList = "id",unique = true)})
public class Insurance {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Date starting;

    @Column
    private Date ending;

    @Column
    private float price;

    @Column
    private Integer status;

    public Insurance(String name, Date starting, Date ending, float price, Integer status) {
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
        this.status = status;
    }

    public Insurance(String name, Date starting, Date ending, float price) {
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
        this.status=1;
    }

    public Insurance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}
