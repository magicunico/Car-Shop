package com.example.demo.brand;

import com.example.demo.producer.Producer;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brand", indexes = {@Index(name = "brand_pkey",columnList = "id",unique = true)})
public class Brand {

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
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @Getter
    @Setter
    @Column
    private int status;

    public Brand(String name, Producer producer) {
        this.name = name;
        this.producer = producer;
        this.status = 1;
    }

    public Brand() {
    }


    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }


}
