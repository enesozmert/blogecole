package com.opensource.blogecole.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @Column(name="firstName",nullable=false)
    private String firstName;

    @Column(name="lastName",nullable=false)
    private String lastName;

    @Column(name="eMail",unique=true,nullable=false)
    private String email;

    @Column(name="password",nullable=false)
    private String password;

    @Column(name="emailVerified",nullable=false)
    private boolean emailVerified;

    @Column(name="emailVerifyCode",nullable=false)
    private String emailVerifyCode;

    public User(String firstName, String lastName, String email, boolean emailVerified, String password, String emailVerifyCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.emailVerified = emailVerified;
        this.emailVerifyCode = emailVerifyCode;
    }
}
