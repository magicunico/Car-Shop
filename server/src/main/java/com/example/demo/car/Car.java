package com.example.demo.car;

import com.example.demo.brand.Brand;
import com.example.demo.warehouse.Warehouse;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car",indexes = {@Index(name = "car_pkey",columnList = "id",unique = true)})
public class Car {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column
    private String color;

    @Getter
    @Setter
    @Column
    private float price;

    @Getter
    @Setter
    @Column
    private String body;

    @Getter
    @Setter
    @Column
    private String gearbox;

    @Getter
    @Setter
    @Column
    private int status;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Car(String color, float price, String body, String gearbox, int status, Warehouse warehouse, Brand brand) {
        this.color = color;
        this.price = price;
        this.body = body;
        this.gearbox = gearbox;
        this.status = status;
        this.warehouse = warehouse;
        this.brand = brand;
    }

    public Car(String color, float price, String body, String gearbox, Warehouse warehouse, Brand brand) {
        this.color = color;
        this.price = price;
        this.body = body;
        this.gearbox = gearbox;
        this.warehouse = warehouse;
        this.brand = brand;
        this.status=1;
    }

    public Car() {
    }


    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}
