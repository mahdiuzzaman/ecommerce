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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mahdi.ecommerce.util.FileUploadUtility;
import com.mahdi.ecommerce.validator.ProductValidator;
import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dao.ProductDAO;
import com.mahdi.ecommercebackend.dto.Category;
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
	
	
	@ModelAttribute
	// adds attributes for all requestMapping
	public void addACategoryModel(Model model) {
		Category category = new Category();
		category.setActive(true);
		model.addAttribute("category", category);
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
				model.addAttribute("message", "Product added successfully");
			}
			if (success.equals("category")) {
				model.addAttribute("message", "Category added successfully");
			}
		}

		return "page";
	}

	@PostMapping("/productadd")
	public String productSubmission(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		// BindingResult should always come after modelAttributr parameter and before
		// [BindingResult] is Spring’s object that holds the result of the validation

		//validate only if its a new product
		if(product.getId()==0) {
			new ProductValidator().validate(product, bindingResult);
		}else {
			if(!product.getFile().getOriginalFilename().equals("")) {//if file name is not empty validate it
				new ProductValidator().validate(product, bindingResult);
			}
		}
		

		// check if there are any error
		if (bindingResult.hasErrors()) {
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Product");
			model.addAttribute("message", "Product Submission Failed");
			return "page";
		}

		logger.info(product.toString());
		
		if(product.getId()==0) {
			productDAO.add(product);
		}else {
			productDAO.update(product);
		}
		

		if (!product.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, product.getFile(), product.getCode());
		}

		return "redirect:/manage/product?success=product";
	}

	@PostMapping(value = "/product/{id}/activation")
	@ResponseBody
	public String managePostProductActivation(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
		return (isActive) ? "Product Dectivated Successfully!" : "Product Activated Successfully";
	}

	@GetMapping("/{id}/product")
	public String editPoduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("userClickManageProduct", true);
		model.addAttribute("title", "Manage Product");
		Product product = productDAO.get(id);
		model.addAttribute("product", product);
		return "page";
	}
	
	@PostMapping("/category")
    public String addCategory(@ModelAttribute("category") Category category) {
    	categoryDao.add(category);
    	return "redirect:/manage/product?success=category";
    }
}
