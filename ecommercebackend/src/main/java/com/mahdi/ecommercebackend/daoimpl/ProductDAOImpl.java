package com.mahdi.ecommercebackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahdi.ecommercebackend.dao.ProductDAO;
import com.mahdi.ecommercebackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Product product) {
		try {

			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product get(int id) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct = "FROM Product WHERE active=: active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct, Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategory = "From Product Where  active=:active and categoryId=:id ";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductByCategory, Product.class);
		query.setParameter("active", true);
		query.setParameter("id", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String selectLatestActiveProduct = "From Product Where active=:active Order by id";
		Query query = sessionFactory.getCurrentSession().createQuery(selectLatestActiveProduct, Product.class);
		query.setParameter("active", true);
		query.setFirstResult(0);
		query.setMaxResults(count);
		return query.getResultList();
	}

}
