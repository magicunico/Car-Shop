package com.example.demo.employee;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "employee",indexes = {@Index(name = "employee_pkey",columnList = "id",unique = true)})
public class Employee  {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String pesel;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private String surname;

    @Getter
    @Setter
    @Column
    private String address;

    @Getter
    @Setter
    @Column
    private Date date;

    @Getter
    @Setter
    @Column
    private float salary;

    @Getter
    @Setter
    @Column
    private int status;

    public Employee(String pesel, String name, String surname, String address, Date date, float salary, int status) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.date = date;
        this.salary = salary;
        this.status = status;
    }

    public Employee(String pesel, String name, String surname, String address, float salary, int status) {
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


    public void setActive(){
        this.status=1;
    }

    public void setNonactive(){
        this.status=0;
    }
}





