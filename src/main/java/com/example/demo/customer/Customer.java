package com.example.demo.customer;

import com.example.demo.person.Person;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Table(name = "customer",indexes = {@Index(name = "customer_pkey",columnList = "id",unique = true)})
public class Customer extends Person {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Customer(String pesel, String name, String surname, String address) {
        super(pesel, name, surname, address);
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
