package com.example.demo.brand;

import com.example.demo.producer.Producer;

import javax.persistence.*;

@Entity
@Table(name = "brand", indexes = {@Index(name = "brand_pkey",columnList = "id",unique = true)})
public class Brand {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @Column
    private Integer status;

    public Brand(String name, Producer producer) {
        this.name = name;
        this.producer = producer;
        this.status = 1;
    }

    public Brand() {
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

    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }

    public void setStatus(Integer status){
        this.status=status;
    }

}
