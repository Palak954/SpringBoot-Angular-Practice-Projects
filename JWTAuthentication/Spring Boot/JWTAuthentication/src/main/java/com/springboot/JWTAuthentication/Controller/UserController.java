package com.springboot.JWTAuthentication.Controller;

import com.springboot.JWTAuthentication.Entity.User;
import com.springboot.JWTAuthentication.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }
    @PostMapping("/createNewUser")
    public User createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }
    @GetMapping("/fetchUser/{username}")
    public User fetchUser(@PathVariable String username){
        return userService.fetchUser(username);
    }

    @GetMapping("/fetchUsers")
    public List<User> fetchUsers(){
        return userService.fetchUsers();
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "this URL is only accessible to admin users";
    }
    @GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "this URL is only accessible to normal users";
    }
}
