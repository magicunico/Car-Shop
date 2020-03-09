package com.example.demo.insurance;

import java.util.Date;

public class InsuranceDTO {

    private Long id;

    private String name;

    private Date starting;

    private Date ending;

    private float price;

    private Integer status;

    public InsuranceDTO(Long id, String name, Date starting, Date ending, float price, Integer status) {
        this.id = id;
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
        this.status = status;
    }

    public InsuranceDTO(Long id, String name, Date starting, Date ending, float price) {
        this.id = id;
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
        this.status=1;
    }

    public InsuranceDTO() {
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
