package com.mahdi.ecommerce.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String hanlderNoHandlerFoundException(Model model) {
		model.addAttribute("errorTitle", "This page is not Constructed");
		model.addAttribute("errorDescription", "The page you are looking for is not availabel");
		model.addAttribute("title", "404 error page");
		return "error";
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public String hanlderProductNotFoundException(Model model) {
		model.addAttribute("errorTitle", "Product Not Available");
		model.addAttribute("errorDescription", "The product you are looking for is not availabel");
		model.addAttribute("title", "Product Unavailable");
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String hanlderException(Model model) {
		model.addAttribute("errorTitle", "Contact to the Adminstrator");
		model.addAttribute("errorDescription", "Not Found");
		model.addAttribute("title", "Error");
		return "error";
	}
}
