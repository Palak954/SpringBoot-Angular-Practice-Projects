package com.springboot.JWTAuthentication.Service;

import com.springboot.JWTAuthentication.Entity.Role;
import com.springboot.JWTAuthentication.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role){
        return roleRepository.save(role);
    }
}
