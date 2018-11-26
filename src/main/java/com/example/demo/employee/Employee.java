package com.example.demo.employee;

import com.example.demo.person.Person;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "employee",indexes = {@Index(name = "employee_pkey",columnList = "id",unique = true)})
public class Employee extends Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private float salary;

    public Employee(String pesel, String name, String surname, String address, Date date, float salary) {
        super(pesel, name, surname, address);
        this.date = date;
        this.salary = salary;
    }

    public Employee(Date date, float salary) {
        this.date = date;
        this.salary = salary;
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}




