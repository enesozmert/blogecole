package com.opensource.blogecole.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="authorId")
    private User author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "blog_category",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories;

    @Column(name="commentId",nullable=false)
    private int commentId;

    @OneToMany(mappedBy="blog")
    @JsonIgnore()
    Set<Comment> comments;

    public Blog(String title, String description, String body, int authorId) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.authorId = authorId;
    }
}
