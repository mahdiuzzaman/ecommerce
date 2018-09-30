package com.mahdi.ecommercebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active=:active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	// returns persistant instance based on primary_key
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try {
			// add category to the database table

			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			// add category to the database table

			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * setActive = false is considered as deleted.
	 */
	@Override
	public boolean delete(Category category) {
		try {

			category.setActive(false);

			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
