package com.springboot.JWTAuthentication.Service;

import com.springboot.JWTAuthentication.Entity.User;
import com.springboot.JWTAuthentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createNewUser(User user){
        return userRepository.save(user);
    }

    public User fetchUser(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> fetchUsers(){
        return userRepository.findAll();
    }
}
