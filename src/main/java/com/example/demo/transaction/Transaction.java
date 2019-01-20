package com.example.demo.transaction;


import com.example.demo.car.Car;
import com.example.demo.customer.Customer;
import com.example.demo.employee.Employee;
import com.example.demo.insurance.Insurance;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction",indexes = {@Index(name = "transaction_pkey",columnList = "id",unique = true)})
public class Transaction {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private String payment;

    @Column
    private String place;

    @Column
    private float sum;

    @OneToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @Column
    private Integer status;

    public Transaction(Date date, String payment, String place, float sum, Car car, Customer customer, Insurance insurance,Employee employee, Integer status) {
        this.date = date;
        this.payment = payment;
        this.place = place;
        this.sum = sum;
        this.car = car;
        this.customer = customer;
        this.employee = employee;
        this.insurance = insurance;
        this.status = status;
    }

    public Transaction(Date date, String payment, String place, float sum, Car car, Customer customer, Employee employee, Insurance insurance) {
        this.id = id;
        this.date = date;
        this.payment = payment;
        this.place = place;
        this.sum = car.getPrice()+insurance.getPrice();
        this.car = car;
        this.customer = customer;
        this.employee = employee;
        this.insurance = insurance;
        this.status=1;
    }

    public Transaction() {
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public float getSum() {
        return car.getPrice()+insurance.getPrice();
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
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
