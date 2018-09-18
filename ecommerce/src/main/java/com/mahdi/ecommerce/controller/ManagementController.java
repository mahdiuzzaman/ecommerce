package com.mahdi.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahdi.ecommerce.util.FileUploadUtility;
import com.mahdi.ecommerce.validator.ProductValidator;
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
	public String productSubmission(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		// BindingResult should always come after modelAttributr parameter and before
		// [BindingResult] is Spring’s object that holds the result of the validation
		
		
		new ProductValidator().validate(product, bindingResult);
		

		// check if there are any error
		if (bindingResult.hasErrors()) {
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Product");
			model.addAttribute("message", "Product Submission Failed");
			return "page";
		}

		logger.info(product.toString());
		productDAO.add(product);

		if (!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getFile(), product.getCode());
		}

		return "redirect:/manage/product?success=product";
	}

}
