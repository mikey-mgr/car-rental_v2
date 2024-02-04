package com.Mike.Proj.service;

import java.util.List;

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
	
	public List<Category> listCategory() {
		return categoryRepo.findAll();
	}

	public void editCategory(int categoryId, Category updatedCategory) {
		Category category = categoryRepo.getById(categoryId);
		category.setCategoryName(updatedCategory.getCategoryName());
		category.setDescription(updatedCategory.getDescription());
		category.setImageUrl(updatedCategory.getImageUrl());
		categoryRepo.save(category);
	}

	public boolean findById(int categoryId) {
		return categoryRepo.findById(categoryId).isPresent();
	}
}