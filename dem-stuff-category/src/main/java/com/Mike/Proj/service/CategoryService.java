package com.Mike.Proj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mike.Proj.model.Category;
import com.Mike.Proj.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	public void createCategory(Category category) {
		categoryRepo.save(category);
		
	}

	
}
