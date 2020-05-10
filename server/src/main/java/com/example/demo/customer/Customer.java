package com.example.demo.customer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
@Table(name = "customer",indexes = {@Index(name = "customer_pkey",columnList = "id",unique = true)})
public class Customer {

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
   private int status;

    public Customer(String pesel, String name, String surname, String address) {
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.status=1;
    }

    public Customer(long id,String pesel, String name, String surname, String address) {
        this.id=id;
        this.pesel = pesel;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.status=1;
    }

    public Customer() {
    }



    public void setActive() {
        this.status = 1;
    }

    public void setNonctive() {
        this.status = 0;
    }
}
