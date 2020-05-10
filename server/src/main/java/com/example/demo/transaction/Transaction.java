package com.example.demo.transaction;


import com.example.demo.car.Car;
import com.example.demo.customer.Customer;
import com.example.demo.employee.Employee;
import com.example.demo.insurance.Insurance;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction",indexes = {@Index(name = "transaction_pkey",columnList = "id",unique = true)})
public class Transaction {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column
    private Date date;

    @Getter
    @Setter
    @Column
    private String payment;

    @Getter
    @Setter
    @Column
    private String place;

    @Getter
    @Setter
    @Column
    private float sum;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name="car_id")
    private Car car;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    @Getter
    @Setter
    @Column
    private int status;

    public Transaction(Date date, String payment, String place, float sum, Car car, Customer customer, Insurance insurance,Employee employee, int status) {
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



    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}
