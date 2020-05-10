package com.example.demo.repair;

import com.example.demo.car.Car;
import com.example.demo.employee.Employee;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "repair",indexes = {@Index(name = "repair_pkey",columnList = "id",unique = true)})
public class Repair {

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
    private float price;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Getter
    @Setter
    @Column
    private int status;

    public Repair(String name, float price, Car car, Employee employee, int status) {
        this.name = name;
        this.price = price;
        this.car = car;
        this.employee = employee;
        this.status = status;
    }

    public Repair(String name, float price, Car car, Employee employee) {
        this.name = name;
        this.price = price;
        this.car = car;
        this.employee = employee;
        this.status=1;
    }

    public Repair() {
    }


    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}

