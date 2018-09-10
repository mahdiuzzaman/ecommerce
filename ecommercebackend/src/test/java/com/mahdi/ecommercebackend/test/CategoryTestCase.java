package com.mahdi.ecommercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		//creating CategoryDAO bean
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mahdi.ecommercebackend");
		context.refresh();
		categoryDAO  = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryDAO() {
		Category category = new Category();
		
		category.setName("Television");
		category.setDescription("Some description for tv");
		category.setImageURL("cat_1.png");
		
		assertEquals("Susccessfully added category", true, categoryDAO.add(category));
	}

}

































