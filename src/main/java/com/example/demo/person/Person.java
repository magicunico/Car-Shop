package com.example.demo.person;


import javax.persistence.*;

@Entity
@Table(name = "insurance",indexes = {@Index(name = "insurance_pkey",columnList = "id",unique = true)})
public class Person {
    @Id
    @Column
    private String pesel;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    public Person(String pesel, String name, String surname, String address) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person() {
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
}
