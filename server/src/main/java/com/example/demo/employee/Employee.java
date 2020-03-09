package com.example.demo.employee;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table (name = "employee",indexes = {@Index(name = "employee_pkey",columnList = "id",unique = true)})
public class Employee  {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String pesel;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private Date date;

    @Column
    private float salary;

    @Column
    private Integer status;

    public Employee(String pesel, String name, String surname, String address, Date date, float salary, Integer status) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.date = date;
        this.salary = salary;
        this.status = status;
    }

    public Employee(String pesel, String name, String surname, String address, float salary, Integer status) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.date = Calendar.getInstance().getTime();
        this.salary = salary;
        this.status = status;
    }


    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
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





