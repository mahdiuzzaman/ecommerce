package com.mahdi.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mahdi.ecommerce.exception.ProductNotFoundException;
import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dao.ProductDAO;
import com.mahdi.ecommercebackend.dto.Category;
import com.mahdi.ecommercebackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "home", "index" })
	public String index(Model model) {

		model.addAttribute("title", "Home");

		//logger.info("Controller Method: index() -INFO ");
		//logger.debug("Controller Method: index() -DEBUG ");

		model.addAttribute("categories", categoryDao.list());

		model.addAttribute("userClickHome", true);
		return "page";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About Us");
		model.addAttribute("userClickAbout", true);
		return "page";
	}

	@RequestMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("title", "Contact Us");
		model.addAttribute("userClickContact", true);
		return "page";
	}

	@RequestMapping(value = "/show/all/products")
	public String showAllProducts(Model model) {

		model.addAttribute("title", "All Product");

		model.addAttribute("categories", categoryDao.list());

		model.addAttribute("userClickAllProducts", true);
		return "page";
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public String showCategoryProducts(@PathVariable("id") int id, Model model) {
		// category dao to fetch a single category

		Category category = null;

		category = categoryDao.get(id);

		model.addAttribute("title", category.getName());

		model.addAttribute("categories", categoryDao.list());

		model.addAttribute("category", category);

		model.addAttribute("userClickCategoryProducts", true);
		return "page";
	}

	// controller for a single product

	@RequestMapping("show/{id}/product")
	public String showSinglePage(Model model, @PathVariable int id) throws ProductNotFoundException {
		Product product = productDAO.get(id);
		if (product == null) {
			throw new ProductNotFoundException();
		}
		product.setViews(product.getViews() + 1);
		// update view count
		productDAO.update(product);
		model.addAttribute("title", product.getName());
		model.addAttribute("product", product);
		model.addAttribute("userClickShowProduct", true);
		return "page";
	}
}







