package com.mahdi.ecommercebackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mahdi.ecommercebackend.dto.Category;


public interface CategoryDAO {
	
	//get category by id
	Category get(int id);
	
	//its returs a list of category
	List<Category> list();
	
	//return true if a category is added to the database
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);	
    
}
