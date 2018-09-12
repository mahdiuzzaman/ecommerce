package com.mahdi.ecommercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mahdi.ecommercebackend.dao.ProductDAO;
import com.mahdi.ecommercebackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mahdi.ecommercebackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	public void testCRUDProduct() {

		product = new Product();
		product.setName("Galaxy s6");
		product.setBrand("Samsung");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplier(1);
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplier(2);
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		product = new Product();
		product.setName("Selfie S53");
		product.setBrand("Moot");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplier(3);
		assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record!", true, productDAO.update(product));

		assertEquals("Something went wrong while deleting the existing record!", true, productDAO.delete(product));

		// list
		assertEquals("Something went wrong while fetching the list of products!", 2,
				productDAO.listActiveProducts().size());

	}

	@Test
	public void testListActiveProducts() {
		assertEquals("Error in fetching the list of products!", 5, productDAO.listActiveProducts().size());
	}

	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Error in fetching the list of products!", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Error in fetching the list of products!", 2, productDAO.listActiveProductsByCategory(1).size());
	}

	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Error in fetching the list of products!", 3, productDAO.getLatestActiveProduct(3).size());

	}

}
