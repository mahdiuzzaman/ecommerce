package com.mahdi.ecommercebackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mahdi.ecommercebackend.dto.Category;


public interface CategoryDAO {
	
	//method
	boolean add(Category category);
	List<Category> list();
	Category get(int id);
    
}
