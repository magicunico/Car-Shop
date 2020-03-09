package com.example.demo.warehouse;

import javax.persistence.*;

@Entity
@Table(name = "warehouse",indexes = {@Index(name = "warehouse_pkey",columnList = "id",unique = true)})
public class Warehouse {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer status;

    public Warehouse(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public Warehouse(String name) {

        this.name = name;
        this.status=1;
    }

    public Warehouse(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

