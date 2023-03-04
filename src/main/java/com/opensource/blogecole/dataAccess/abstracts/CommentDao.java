package com.opensource.blogecole.dataAccess.abstracts;

import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {
    Comment findById(int id);
    List<Comment> findAllByText(String text);
}
