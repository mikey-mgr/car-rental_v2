package com.Mike.Proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mike.Proj.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
    

}
