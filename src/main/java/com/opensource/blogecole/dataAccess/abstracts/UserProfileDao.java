package com.opensource.blogecole.dataAccess.abstracts;

import com.opensource.blogecole.entities.concretes.User;
import com.opensource.blogecole.entities.concretes.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {
    UserProfile findById(int id);
}
