package com.example.demo.producer;

import javax.persistence.*;

@Entity
@Table(name = "producer",indexes = {@Index(name = "producer_pkey",columnList = "id",unique = true)})
public class Producer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Producer(String name) {
        this.name = name;
    }

    public Producer() {
    }

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
