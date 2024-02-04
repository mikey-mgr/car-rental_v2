package com.Mike.Proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mike.Proj.model.AuthenticationToken;
import com.Mike.Proj.model.User;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer>{

    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);

    
}
