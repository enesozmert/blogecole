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
@Table(name="Categories")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @Column(name="userId",nullable=false)
    private int userId;

    @Column(name="blogId",nullable=false)
    private int blogId;

    @Column(name="text",nullable=false)
    private int text;

    public Comment(int userId, int blogId, int text) {
        this.userId = userId;
        this.blogId = blogId;
        this.text = text;
    }
}
