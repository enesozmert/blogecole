package com.opensource.blogecole.dataAccess.abstracts;


import com.opensource.blogecole.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findById(int id);
}
