package com.Mike.Proj.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Mike.Proj.model.User;
import com.Mike.Proj.model.Wishlist;


@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);

    @Query(value = "SELECT * FROM wishlist WHERE wishlist.car_id = ?1", nativeQuery = true)
    Optional<List<Wishlist>> findAllByProductId(Integer productId);

}
