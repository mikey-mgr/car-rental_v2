package com.Mike.Proj.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mike.Proj.model.Category;
import com.Mike.Proj.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/createcategory")
	public String createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return "success";
		
	}
	
}
