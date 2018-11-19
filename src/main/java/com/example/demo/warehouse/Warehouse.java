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

    public Warehouse(String name) {
        this.name = name;
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
}
