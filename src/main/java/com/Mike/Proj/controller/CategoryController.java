package com.Mike.Proj.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Mike.Proj.model.Category;
import com.Mike.Proj.service.CategoryService;

@RestController
@RequestMapping("/category")
//for configuring access to the backend controller from
//a different server/origin ie. vue app
@CrossOrigin("http://localhost:8080")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/create")
	public String createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return "success";
		
	}
	
	@GetMapping("/list")
	public List<Category> listCategory() {
		return categoryService.listCategory();
		
	}
	
}
