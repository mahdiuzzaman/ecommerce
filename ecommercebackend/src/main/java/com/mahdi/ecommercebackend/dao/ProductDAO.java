package com.mahdi.ecommercebackend.dao;

import java.util.List;

import com.mahdi.ecommercebackend.dto.Product;

public interface ProductDAO {
	
	/*
	 * basic CRUD operation
	 * */
	
	public boolean add(Product product);
	public Product get(int id);
	public boolean update(Product product);
	public boolean delete(Product product);
	
	
	/*
	 *  business logic
	 * */
	
	public List<Product> list();
	
	public List<Product>  listActiveProducts();
	public List<Product> listActiveProductsByCategory(int categoryId);
	public List<Product> getLatestActiveProduct(int count);
	
	
	
}
