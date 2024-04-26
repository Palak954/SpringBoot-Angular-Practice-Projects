package com.springboot.JWTAuthentication.Controller;

import com.springboot.JWTAuthentication.Entity.Role;
import com.springboot.JWTAuthentication.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/createNewRole")
    public Role createNewRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
