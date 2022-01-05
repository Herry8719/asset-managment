package com.assingment.assingment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assingment.assingment.model.Category;

public interface CategoryDao  extends JpaRepository<Category,Integer>  {

}
