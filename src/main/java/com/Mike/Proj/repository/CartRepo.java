package com.Mike.Proj.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Mike.Proj.model.Cart;
import com.Mike.Proj.model.User;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

    @Query(value = "SELECT * FROM bookings WHERE bookings.car_id = ?1", nativeQuery = true)
    Optional<List<Cart>> findAllByProductId(Integer productId);
    
}