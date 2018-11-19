package com.example.demo.warehouse;

import javax.persistence.*;

@Entity
@Table(name = "warehouse",indexes = {@Index(name = "warehouse_pkey",columnList = "id",unique = true)})
public class Warehouse {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    public Warehouse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Warehouse(){};

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
