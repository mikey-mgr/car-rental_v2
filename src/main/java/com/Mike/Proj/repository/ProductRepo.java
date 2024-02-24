package com.Mike.Proj.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Mike.Proj.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

    @Query(value = "SELECT * FROM car WHERE car.name like %?1%", nativeQuery = true)
    List<Product> findByNameContaining(String name);
}