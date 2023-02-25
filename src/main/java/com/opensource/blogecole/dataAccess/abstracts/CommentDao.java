package com.opensource.blogecole.dataAccess.abstracts;

import com.opensource.blogecole.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Integer> {
}
