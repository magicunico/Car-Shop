package com.example.demo.insurance;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "insurance",indexes = {@Index(name = "insurance_pkey",columnList = "id",unique = true)})
public class Insurance {

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
    private Date starting;

    @Getter
    @Setter
    @Column
    private Date ending;

    @Getter
    @Setter
    @Column
    private float price;

    @Getter
    @Setter
    @Column
    private int status;

    public Insurance(String name, Date starting, Date ending, float price, int status) {
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
        this.status = status;
    }

    public Insurance(String name, Date starting, Date ending, float price) {
        this.name = name;
        this.starting = starting;
        this.ending = ending;
        this.price = price;
        this.status=1;
    }

    public Insurance() {
    }



    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}
