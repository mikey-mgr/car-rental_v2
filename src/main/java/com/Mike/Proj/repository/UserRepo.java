package com.Mike.Proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mike.Proj.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    User findByEmail(String email);

}
