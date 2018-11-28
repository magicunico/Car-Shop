package com.example.demo.customer;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Table(name = "customer",indexes = {@Index(name = "customer_pkey",columnList = "id",unique = true)})
public class Customer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column
    private String pesel;

   @Column
    private String name;

   @Column
   private String surname;

   @Column
    private String address;

   @Column
   private Integer status;

    public Customer(String pesel, String name, String surname, String address) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.status=1;
    }

    public Customer(Long id,String pesel, String name, String surname, String address) {
        this.id=id;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.status=1;
    }

    public Customer() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status){this.status=status;}

    public void setActive() {
        this.status = 1;
    }

    public void setNonctive() {
        this.status = 0;
    }
}
