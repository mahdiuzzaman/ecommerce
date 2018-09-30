package com.mahdi.ecommercebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource; //provides connection pooling features
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration //indicates that this is a configuration class
@ComponentScan(basePackages = { "com.mahdi.ecommercebackend" }) 
@EnableTransactionManagement 
public class HibernateConfig {
	private final String db_url = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
	private final String db_driver = "com.mysql.cj.jdbc.Driver";
	private final String db_dialect = "org.hibernate.dialect.MySQL8Dialect";
	private final String db_username = "admin";
	private final String db_password = "admin";

	@Bean
	public DataSource getDataSource() {  //connection pooling
		BasicDataSource basicDataSource = new BasicDataSource();

		basicDataSource.setDriverClassName(db_driver);
		basicDataSource.setUrl(db_url);
		basicDataSource.setUsername(db_username);
		basicDataSource.setPassword(db_password);

		return basicDataSource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) { // session factory is created using connection provided by datasource
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.mahdi.ecommercebackend.dto");

		return builder.buildSessionFactory();
	}

	// hibernate properties will be returned
	private Properties getHibernateProperties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", db_dialect);

		properties.put("hibernate.show_sql", "true");

		properties.put("hibernate.format_sql", "true");

		/*
		 * update - automatically create table if not exist, and also do update table if
		 * entity class changes create - drop the existing one and re create it
		 */
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {// handles transaction management in Spring

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);

		return hibernateTransactionManager;

	}

}
