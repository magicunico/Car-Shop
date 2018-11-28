package com.example.demo.car;

import com.example.demo.brand.Brand;
import com.example.demo.warehouse.Warehouse;

public class CarDTO {

    private Long id;

    private String color;

    private float price;

    private String body;

    private String gearbox;

    private Warehouse warehouse;

    private Brand brand;

    private Integer status;

    public CarDTO(Long id, String color, float price, String body, String gearbox, Warehouse warehouse, Brand brand, Integer status) {
        this.id = id;
        this.color = color;
        this.price = price;
        this.body = body;
        this.gearbox = gearbox;
        this.warehouse = warehouse;
        this.brand = brand;
        this.status = status;
    }

    public CarDTO(Long id, String color, float price, String body, String gearbox, Warehouse warehouse, Brand brand) {
        this.id = id;
        this.color = color;
        this.price = price;
        this.body = body;
        this.gearbox = gearbox;
        this.warehouse = warehouse;
        this.brand = brand;
        this.status=1;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}

