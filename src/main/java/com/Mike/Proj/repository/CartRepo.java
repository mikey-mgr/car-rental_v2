package com.Mike.Proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Mike.Proj.model.Cart;
import com.Mike.Proj.model.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
    
}