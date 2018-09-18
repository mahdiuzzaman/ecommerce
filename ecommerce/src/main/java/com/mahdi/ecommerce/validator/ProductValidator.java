package com.mahdi.ecommerce.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mahdi.ecommercebackend.dto.Product;

public class ProductValidator implements Validator {

	// checks whether the validation is against Product.class
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select and image file to Upload");
		}

		if (!(product.getFile().getContentType().equals("image/jpeg")
				|| product.getFile().getContentType().equals("image/png")
				|| product.getFile().getContentType().equals("image/gif"))) {
			errors.rejectValue("file", null, "Please use image file only (.jpeg, .png, gif)");

		}
	}

}
