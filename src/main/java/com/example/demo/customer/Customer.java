package com.example.demo.customer;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Table(name = "customer",indexes = {@Index(name = "customer_pkey",columnList = "id",unique = true)})
public class Customer {

    @Id
    @Column
    private int id;

   @Column
    private String pesel;

   @Column
    private String name;

   @Column
   private String surname;

   @Column
    private String address;

    public Customer(int id, String pesel, String name, String surname, String address) {
        this.id = id;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
