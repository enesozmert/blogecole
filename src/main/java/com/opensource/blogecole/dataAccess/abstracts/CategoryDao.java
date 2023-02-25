package com.opensource.blogecole.dataAccess.abstracts;

import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category findById(int id);
}
