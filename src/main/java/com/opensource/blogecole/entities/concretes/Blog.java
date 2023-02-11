package com.opensource.blogecole.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Blogs")
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private int id;

    @Column(name="title",nullable=false)
    private String title;

    @Column(name="description",nullable=false)
    private String description;

    @Column(name="body",nullable=false)
    private String body;

    @Column(name="authorId",nullable=false)
    private int authorId;

    @Column(name="categoryId",nullable=false)
    private int categoryId;

    @Column(name="commentId",nullable=false)
    private int commentId;
}
