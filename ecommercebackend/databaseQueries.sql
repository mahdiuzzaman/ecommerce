CREATE TABLE category(

  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(255),
  is_active BOOLEAN,
  
  CONSTRAINT pk_category_id PRIMARY KEY (id)

);