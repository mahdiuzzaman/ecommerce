package com.mahdi.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dao.ProductDAO;
import com.mahdi.ecommercebackend.dto.Product;



@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@ModelAttribute
	// adds attributes for all requestMapping
	public void addCategoryListToModel(Model model) {
		model.addAttribute("categories", categoryDao.list());
	}

	@GetMapping("/product")
	public String showManageProduct(Model model, @RequestParam(name = "success", required = false) String success) {
		model.addAttribute("userClickManageProduct", true);
		model.addAttribute("title", "Manage Product");

		Product product = new Product();
		product.setSupplier(1);
		product.setActive(true);
		model.addAttribute("product", product);	
		if (success != null) {
			if (success.equals("product")) {
				model.addAttribute("message", "Procuce added successfully");
			}
		}

		return "page";
	}

	@PostMapping("/productadd")
	public String productSubmission(@ModelAttribute("product") Product product) {
		logger.info(product.toString());
		productDAO.add(product);
		return "redirect:/manage/product?success=product";
	}

}
