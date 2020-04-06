package com.example.demo.login;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(unique = true)
    private String username;
    @Column
    private String password;
}
