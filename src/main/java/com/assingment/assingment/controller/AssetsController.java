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

import com.assingment.assingment.dao.AssetsDao;
import com.assingment.assingment.dao.CategoryDao;
import com.assingment.assingment.model.Assets;
import com.assingment.assingment.model.Category;



@Controller
public class AssetsController {
	
	private Logger logger = LoggerFactory.getLogger(AssetsController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private AssetsDao assetsDao;
	
	@PostMapping("/addAssets")
	public Assets addAsset(@RequestBody Assets asset) {
		logger.info(" addAsset ");
		Category category = categoryDao.findById(asset.getCategory().getId()).orElse(null);
		if(null == category) {
			category = new Category();
			category.setName(asset.getCategory().getName());
			category.setDescription(asset.getCategory().getDescription());
			categoryDao.save(category);
			logger.info("In the if.... addAsset ");
		}
		
		asset.setCategory(category);
		
		return assetsDao.save(asset);
	}
	@GetMapping("/assets")
	public List<Assets> getAssets(){
		return assetsDao.findAll();
	}
	
	@GetMapping("/assets/{name}")
	public List<Assets> getAssets(@PathVariable String name){
		return assetsDao.findByName(name);
	}
	
	@PutMapping("/assets/{id}")
	public Assets updateAsset(@RequestBody Assets request,@PathVariable int id) {
		Assets asset = assetsDao.findById(id).get();
		logger.info("asset is"+asset );
		if(null == asset) {
			return assetsDao.save(request);
		}
		asset.setId(id);
		asset.setName(request.getName());
		asset.setCategory(request.getCategory());
		return assetsDao.save(asset);
	}

}
