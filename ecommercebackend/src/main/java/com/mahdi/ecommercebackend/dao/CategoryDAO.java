package com.mahdi.ecommercebackend.dao;

import java.util.List;

import com.mahdi.ecommercebackend.dto.Category;

public interface CategoryDAO {
	
	//method
	List<Category> list();
	Category get(int id);
    
}
