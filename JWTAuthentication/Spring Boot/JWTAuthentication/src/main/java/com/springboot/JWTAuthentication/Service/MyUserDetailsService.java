package com.springboot.JWTAuthentication.Service;

import com.springboot.JWTAuthentication.Entity.JwtRequest;
import com.springboot.JWTAuthentication.Entity.JwtResponse;
import com.springboot.JWTAuthentication.Entity.User;
import com.springboot.JWTAuthentication.Repository.UserRepository;
import com.springboot.JWTAuthentication.Util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticate(username , password);
        final UserDetails userDetails = loadUserByUsername(username);
        String generatedToken = jwtHelper.generateToken(userDetails);
        User user = userRepository.findById(username).get();
        return new JwtResponse(user , generatedToken);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        if(user == null)
            throw new UsernameNotFoundException("user not found");

        else {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), getAuthorities(user)
            );
        }
    }
    private Set getAuthorities(User user){
        Set authorities = new HashSet();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }
    public void authenticate(String username , String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username , password));
        }
        catch (DisabledException e){
            throw new Exception("user disabled");
        }
        catch (BadCredentialsException e){
            throw new Exception("Bad credentials from User");
        }
    }

}
