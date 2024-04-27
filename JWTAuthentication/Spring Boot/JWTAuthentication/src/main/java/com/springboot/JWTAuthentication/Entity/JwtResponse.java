package com.springboot.JWTAuthentication.Entity;

import org.springframework.stereotype.Component;

@Component
public class JwtResponse {
    private User user;
    private String jwtToken;

    public JwtResponse(User user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public JwtResponse() {
    }

    public User getUser() {
        return user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "user=" + user +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
