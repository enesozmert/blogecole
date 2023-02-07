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
@Table(name="UserProfiles")
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @Column(name="userId",nullable=false)
    private int userId;

    @Column(name="ImagePath",nullable=true)
    private String imagePath;

    public UserProfile(int userId, String imagePath) {
        this.userId = userId;
        this.imagePath = imagePath;
    }
}
