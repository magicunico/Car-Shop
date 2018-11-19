package com.example.demo.testdrive;

import com.example.demo.car.Car;
import com.example.demo.customer.Customer;
import com.example.demo.employee.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "testdrive",indexes = {@Index(name = "testdrive_pkey",columnList = "id",unique = true)})
public class Testdrive {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Testdrive(Date date, Employee employee, Customer customer, Car car) {
        this.date = date;
        this.employee = employee;
        this.customer = customer;
        this.car = car;
    }

    public Testdrive() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
