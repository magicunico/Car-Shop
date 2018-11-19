package com.example.demo.repair;

import com.example.demo.car.Car;
import com.example.demo.employee.Employee;

import javax.persistence.*;

@Entity
@Table(name = "repair",indexes = {@Index(name = "repair_pkey",columnList = "id",unique = true)})
public class Repair {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private float price;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Repair(int id, String name, float price, Car car, Employee employee) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.car = car;
        this.employee = employee;
    }

    public Repair() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}

