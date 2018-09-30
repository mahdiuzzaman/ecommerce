package com.mahdi.ecommercebackend.dao;

import java.util.List;

import com.mahdi.ecommercebackend.dto.Address;
import com.mahdi.ecommercebackend.dto.Cart;
import com.mahdi.ecommercebackend.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);

	User get(int id);

	boolean updateCart(Cart cart);
	
	boolean addUser(User user);

	// adding and updating a new address
	Address getAddress(int addressId);

	boolean addAddress(Address address);

	boolean updateAddress(Address address);

	Address getBillingAddress(int userId);

	List<Address> listShippingAddresses(int userId);

}
