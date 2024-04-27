package com.springboot.JWTAuthentication.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtHelper {
    private static final String secret = "kakfkwfnkwfiejwjejqkeklwqmfmmdkkqnknfkjnewjkfnwe";
    private static final int TOKEN_VAIDITY = 3600 * 5;

    public String getUsernameFromToken(String token){
        return getClaimFromToken(token , Claims::getSubject);
    }
    public <T> T getClaimFromToken(String token , Function<Claims , T> claimResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimResolver.apply(claims);
    }
    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    public boolean validateToken(String token , UserDetails userDetails){
        String userName = getUsernameFromToken(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token){
        final Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token , Claims::getExpiration);
    }
    public String generateToken(UserDetails userDetails){
        Map<String , Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VAIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512 , secret)
                .compact();
    }
}
