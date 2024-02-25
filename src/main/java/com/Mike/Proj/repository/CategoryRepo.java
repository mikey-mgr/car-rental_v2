package com.Mike.Proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mike.Proj.model.Category;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
