package com.Mike.Proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mike.Proj.model.CartHistory;

public interface CartHistoryRepo extends JpaRepository<CartHistory, Integer>{

}
