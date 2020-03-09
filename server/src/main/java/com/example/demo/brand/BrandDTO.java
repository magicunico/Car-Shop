package com.example.demo.brand;

import com.example.demo.producer.Producer;

public class BrandDTO {

    private Long id;

    private String name;

    private Producer producer;

    private Integer status;

    public BrandDTO(Long id, String name, Producer producer, Integer status) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.status = status;
    }

    public BrandDTO(Long id, String name, Producer producer) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.status=1;
    }

    public BrandDTO() {
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
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

    public void setNonctive(){
        this.status=0;
    }


}
