package com.springboot.JWTAuthentication.Controller;

import com.springboot.JWTAuthentication.Entity.JwtRequest;
import com.springboot.JWTAuthentication.Entity.JwtResponse;
import com.springboot.JWTAuthentication.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return myUserDetailsService.createJwtToken(jwtRequest);
    }
}
