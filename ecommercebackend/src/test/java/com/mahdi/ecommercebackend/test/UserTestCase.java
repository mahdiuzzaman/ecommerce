package com.mahdi.ecommercebackend.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mahdi.ecommercebackend.dao.UserDAO;
import com.mahdi.ecommercebackend.dto.Address;
import com.mahdi.ecommercebackend.dto.Cart;
import com.mahdi.ecommercebackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mahdi.ecommercebackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	
	/*Unidirectional mapping between User and Cart Entity.
	 * here User is parent and Cart is Child. 
	 * Only Child holds reference to parent Entity.
	 * Parent does not have reference to child Entity
	 * In child entity  @OneToOne and @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_user_id"))
	 * id decleared to achive OneToOne unidirectional mapping between User and Cart
	 * 
	@Test
	public void testAddUser() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		
		//add the address
		assertEquals("failed to add the address", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("failed to add cart", true, userDAO.updateCart(cart));
		}
	}	
		
	
	
	
	 * Testing for Bidirectional OneToOne mapping between User and Cart Entity
	 * Here User is parent and Cart is child Entity.
	 * Both Parent and Child holds reference to each other to access them in both direction
	 * Every time a User is Created a Cart will automatically added to the User
	 * If User is removed, Cart will get removed. 
	 * Hibernat will do it automatically if  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) is declared
	 * 
	@Test
	public void testAddUserBidirectional() {
		
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		if(user.getRole().equals("USER")) {
			cart = new Cart();
			cart.setUser(user);
			
			user.setCart(cart);
			
			
		}
		assertEquals("failed to add cart", true, userDAO.addUser(user));	

	
	}
	
	
	
	 * Bidirectional OneToOne mapping between User nad Cart
	 * Here is the test to see how Hibernate access cild entity through reference inside parent entity.
	 * 
	@Test
	public void testUpdateCart() {
		user = userDAO.getByEmail("hr@gmail.com");
		cart = user.getCart();
		cart.setGrandTotal(10000);
		cart.setCartLines(1);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));			
	} 
*/	
	/*
	 * unidirectional OneToOne mapping between User and Address
	 * Parent: User, Child: Address
	 * */
	@Test
	public void testAddAddress() {
		//add an user
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		assertEquals("Failed to add user", true, userDAO.addUser(user));
		
		//add blling address
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);	
		address.setUser(user);
		assertEquals("Failed to add user", true, userDAO.addAddress(address));

		//add shipping address
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, King Uncle Nagar");
		address.setAddressLineTwo("Near Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		address.setUser(user);
		assertEquals("Failed to add user", true, userDAO.addAddress(address));

		
	}
	
	
	
}
	

