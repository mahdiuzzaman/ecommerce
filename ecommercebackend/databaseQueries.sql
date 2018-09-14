
-- create category table
CREATE TABLE category(

  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(255),
  is_active BOOLEAN,
  
  CONSTRAINT pk_category_id PRIMARY KEY (id)

);


INSERT into category
(name, description, image_url, is_active )
VALUES 
('Laptop', 'Some des of tv', 'cat_1.png', true),
('Television', 'Some des of Mobile', 'cat_2.png', true),
('Mobile', 'Some des of laptop', 'cat_3.png', true);


CREATE TABLE user_detail (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);


INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES
('John', 'Doe', 'ADMIN', TRUE, 'admin', 'jd@gmail.com', '01234567888'),
('Mark', 'Cristopher', 'SUPPLIER', TRUE, '12345', 'mk@gmail.com', '01234567889'),
('Kit', 'Harington', 'SUPPLIER', TRUE, '12345', 'KH@gmail.com', '01234567880');


CREATE TABLE product (
	id INT NOT NULL AUTO_INCREMENT,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)	
);	


INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES 
('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 ),
('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 ),
('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 ),
('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 ),
('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 )






