package com.assingment.assingment.service;

import org.springframework.stereotype.Service;

import com.assingment.assingment.model.Category;

@Service
public class CategoryService {
	
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryRequest [category=" + category + "]";
	}

}
