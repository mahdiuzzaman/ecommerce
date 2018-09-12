package com.mahdi.ecommercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dto.Category;
import com.sun.javafx.runtime.VersionInfo;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		// creating CategoryDAO bean
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mahdi.ecommercebackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testCRUDCategoryDAO() {

		Category category = new Category();
		category.setName("Mobile");
		category.setDescription("Some description for mobile");
		category.setImageURL("cat_1.png");
		category.setActive(true);
		assertEquals("Susccessfully added category", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("Some description for Television");
		category.setImageURL("cat_2.png");
		category.setActive(true);
		assertEquals("Susccessfully added category", true, categoryDAO.add(category));

		category = categoryDAO.get(2);
		assertEquals("Successfully got Category", "Television", category.getName());

		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Susccessfully updated category", true, categoryDAO.update(category));

		category = categoryDAO.get(1);
		assertEquals("Susccessfully deleted category", true, categoryDAO.delete(category));

		assertEquals("Susccessfully fetched list of category", 1, categoryDAO.list().size());

	}
}
