package com.assingment.assingment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assingment.assingment.model.Assets;

public interface AssetsDao extends JpaRepository<Assets,Integer>{
	
	public List<Assets> findByName(String name);

}
