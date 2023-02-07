package com.opensource.blogecole.api.controllers;

import com.opensource.blogecole.business.abstracts.UserService;
import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllers {
    private UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return userService.getAll();
    }
}
