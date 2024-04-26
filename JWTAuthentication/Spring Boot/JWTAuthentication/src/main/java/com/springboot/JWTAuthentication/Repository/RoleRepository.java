package com.springboot.JWTAuthentication.Repository;

import com.springboot.JWTAuthentication.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role , String> {

}
