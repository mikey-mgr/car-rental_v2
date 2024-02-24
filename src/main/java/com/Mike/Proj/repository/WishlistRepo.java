package com.Mike.Proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mike.Proj.model.User;
import com.Mike.Proj.model.Wishlist;


@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);

}
