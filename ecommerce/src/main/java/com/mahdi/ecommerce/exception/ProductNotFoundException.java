package com.mahdi.ecommerce.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	private String msg;

	public ProductNotFoundException() {
		this.msg = "Product is not available";
	}

	public ProductNotFoundException(String string) {
		this.msg = System.currentTimeMillis() + "  :   " + msg;
	}

	public String getMsg() {
		return msg;
	}

}
