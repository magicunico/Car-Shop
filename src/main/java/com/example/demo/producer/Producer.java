package com.example.demo.producer;

import javax.persistence.*;

@Entity
@Table(name = "producer",indexes = {@Index(name = "producer_pkey",columnList = "id",unique = true)})
public class Producer {
    @Id
    @Column
    private int id;

    @Column
    private String name;

    public Producer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Producer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
