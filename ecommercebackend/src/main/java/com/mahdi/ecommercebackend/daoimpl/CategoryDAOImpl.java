package com.mahdi.ecommercebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dto.Category;

@Repository("categoryDao")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		/*
		 * add first category
		 */
		Category cat1 = new Category();

		cat1.setId(1);
		cat1.setName("Television");
		cat1.setDescription("Some description for tv");
		cat1.setImageURL("cat_1.png");
		cat1.setActive(true);

		categories.add(cat1);

		/*
		 * add 2nd category
		 * 
		 * 
		 */

		Category cat2 = new Category();

		cat2.setId(2);
		cat2.setName("Mobile");
		cat2.setDescription("Some description for mobile");
		cat2.setImageURL("cat_2.png");
		cat2.setActive(true);

		categories.add(cat2);

		/*
		 * add 3rdd category
		 */
		Category cat3 = new Category();

		cat3.setId(3);
		cat3.setName("Laptop");
		cat3.setDescription("Some description for Laptop");
		cat3.setImageURL("cat_3.png");
		cat3.setActive(true);

		categories.add(cat3);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		for (Category category : categories) {
			if (category.getId() == id) {
				return category;
			}
			
		}
		return null;
	}
		

}
