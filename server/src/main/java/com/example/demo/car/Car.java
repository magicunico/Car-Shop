package com.example.demo.car;

import com.example.demo.brand.Brand;
import com.example.demo.warehouse.Warehouse;

import javax.persistence.*;

@Entity
@Table(name = "car",indexes = {@Index(name = "car_pkey",columnList = "id",unique = true)})
public class Car {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String color;

    @Column
    private float price;

    @Column
    private String body;

    @Column
    private String gearbox;

    @Column
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Car(String color, float price, String body, String gearbox, Integer status, Warehouse warehouse, Brand brand) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}
