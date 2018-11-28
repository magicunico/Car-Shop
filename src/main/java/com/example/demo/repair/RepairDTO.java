package com.example.demo.repair;

import com.example.demo.car.Car;
import com.example.demo.employee.Employee;

public class RepairDTO {

    private Long id;

    private String name;

    private float price;

    private Car car;

    private Employee employee;

    private Integer status;

    public RepairDTO(String name, float price, Car car, Employee employee, Integer status) {
        this.name = name;
        this.price = price;
        this.car = car;
        this.employee = employee;
        this.status = status;
    }

    public RepairDTO(String name, float price, Car car, Employee employee) {
        this.name = name;
        this.price = price;
        this.car = car;
        this.employee = employee;
        this.status=1;
    }

    public RepairDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
