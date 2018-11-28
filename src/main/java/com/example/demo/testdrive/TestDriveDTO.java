package com.example.demo.testdrive;

import com.example.demo.car.Car;
import com.example.demo.customer.Customer;
import com.example.demo.employee.Employee;

import java.util.Date;

public class TestDriveDTO {
    private Long id;

    private Date date;

    private Employee employee;

    private Customer customer;

    private Car car;

    private Integer status;

    public TestDriveDTO(Date date, Employee employee, Customer customer, Car car, Integer status) {
        this.date = date;
        this.employee = employee;
        this.customer = customer;
        this.car = car;
        this.status = status;
    }

    public TestDriveDTO(Date date, Employee employee, Customer customer, Car car) {
        this.date = date;
        this.employee = employee;
        this.customer = customer;
        this.car = car;
        this.status=1;
    }

    public TestDriveDTO() {
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
