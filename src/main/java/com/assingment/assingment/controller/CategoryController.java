package com.assingment.assingment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assingment.assingment.dao.CategoryDao;
import com.assingment.assingment.model.Category;
import com.assingment.assingment.service.CategoryService;

@Controller
public class CategoryController {
	
	private Logger logger = LoggerFactory.getLogger(AssetsController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody CategoryService request) {
		return categoryDao.save(request.getCategory());
	}
	@GetMapping("/categories")
	public List<Category> getCategories(){
		return categoryDao.findAll();
	}
	
	@PutMapping("/categories/{id}")
	public Category updateCategory(@RequestBody CategoryService request,@PathVariable int id) {
		Category category = categoryDao.findById(id).get();
		if(null == category) {
			return categoryDao.save(request.getCategory());
		}
		category.setId(id);
		category.setName(request.getCategory().getName());
		category.setDescription(request.getCategory().getDescription());
		return categoryDao.save(category);
	}

}
