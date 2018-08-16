package com.mahdi.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "home", "index" })
	public String index(Model model) {
		model.addAttribute("greetings", "Welcone to Springgggggggg MVC");
		return "page";
	}

	

}
