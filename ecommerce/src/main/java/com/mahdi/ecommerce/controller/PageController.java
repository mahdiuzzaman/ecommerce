package com.mahdi.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mahdi.ecommercebackend.dao.CategoryDAO;
import com.mahdi.ecommercebackend.dto.Category;



@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDao;
	

	@RequestMapping(value = { "/", "home", "index" })
	public String index(Model model) {
		model.addAttribute("title", "Home");
		
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
	public String showCategoryProducts(@PathVariable("id") int id ,Model model) {
		//category dao to fetch a single category
		
		Category category = null;
		
		category = categoryDao.get(id);
		
		
		model.addAttribute("title", category.getName());
		
		model.addAttribute("categories", categoryDao.list());
		
		model.addAttribute("category", category); 
		
		model.addAttribute("userClickCategoryProducts", true);
		return "page";
	}
	

}















