package com.example.demo.producer;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producer",indexes = {@Index(name = "producer_pkey",columnList = "id",unique = true)})
public class Producer {
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

    public Producer(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public Producer(String name) {

        this.name = name;
        this.status=1;
    }

    public Producer() {
    }



    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}
