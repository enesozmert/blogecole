package com.opensource.blogecole.api.controllers;

import com.opensource.blogecole.business.abstracts.UserProfileService;
import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.User;
import com.opensource.blogecole.entities.concretes.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userprofiles")
public class UserProfileControllers {
    private UserProfileService userProfileService;

    @Autowired
    public UserProfileControllers(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/add")
    public Result add(UserProfile userProfile){
        return userProfileService.add(userProfile);
    }
    @PostMapping("/update")
    public Result update(UserProfile userProfile){
        return userProfileService.update(userProfile);
    }

    @GetMapping("/getall")
    public DataResult<List<UserProfile>> getAll(){
        return userProfileService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<UserProfile> getById(int id){
        return userProfileService.getById(id);
    }
}
