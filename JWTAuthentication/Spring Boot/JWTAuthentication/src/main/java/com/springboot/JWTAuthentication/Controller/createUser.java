package com.springboot.JWTAuthentication.Controller;

import com.springboot.JWTAuthentication.Entity.User;
import com.springboot.JWTAuthentication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class createUser {
    @Autowired
    private UserService userService;
    @PostMapping("/createNewUser")
    public User createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }
}
