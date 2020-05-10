package com.example.demo.warehouse;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "warehouse",indexes = {@Index(name = "warehouse_pkey",columnList = "id",unique = true)})
public class Warehouse {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private int status;

    public Warehouse(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public Warehouse(String name) {

        this.name = name;
        this.status=1;
    }

    public Warehouse(){};


    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}

