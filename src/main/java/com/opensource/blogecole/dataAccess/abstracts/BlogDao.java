package com.opensource.blogecole.dataAccess.abstracts;

import com.opensource.blogecole.entities.concretes.Blog;
import com.opensource.blogecole.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog, Integer> {
    Blog findById(int id);


}
