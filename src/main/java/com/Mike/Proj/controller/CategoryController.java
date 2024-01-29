package com.Mike.Proj.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mike.Proj.common.APIResponse;
import com.Mike.Proj.model.Category;
import com.Mike.Proj.service.CategoryService;

@RestController
@RequestMapping("/category")
//for configuring access to the backend controller from
//a different server/origin ie. vue app
@CrossOrigin("http://localhost:8500")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<APIResponse> createCategory(@RequestBody Category category) {
		categoryService.createCategory(category);
		return new ResponseEntity<APIResponse>(new APIResponse(true, "New category has been created"), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public List<Category> listCategory() {
		return categoryService.listCategory();
		
	}

	@PostMapping("/update/{categoryId}")
	public ResponseEntity<APIResponse> editCategory(@PathVariable("categoryId")int categoryId, @RequestBody Category updatedCategory){
		if(!categoryService.findById(categoryId)){
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Category not found"), HttpStatus.NOT_FOUND);
		}

		categoryService.editCategory(categoryId, updatedCategory);
		return new ResponseEntity<APIResponse>(new APIResponse(true, "Category updated successfully"), HttpStatus.OK);
		
	}
	
}
