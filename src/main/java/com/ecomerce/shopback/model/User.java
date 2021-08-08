package com.ecomerce.shopback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15)
    @Column(name = "user_name", unique = true)
    private String userName;
    private String password;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Cart cart;

    public User() {

    }

}
