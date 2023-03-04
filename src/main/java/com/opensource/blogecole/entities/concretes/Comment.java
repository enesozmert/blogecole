package com.opensource.blogecole.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Comments")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="blogId")
    @JsonIgnore
    private Blog blog;

    @Column(name="text",nullable=false)
    private int text;

    public Comment(int userId, int blogId, int text) {
        this.userId = userId;
        this.blogId = blogId;
        this.text = text;
    }
}
