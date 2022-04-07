package com.proje.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.model.Product;
import com.proje.model.User;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager manager = factory.createEntityManager();
		
		User user = new User("Yakup", "BAYKARA", new Date());
		
		// 1. Yol
//		Product product1 =  new Product("İ Phone 7", 10000.0, 3, new Date());
//		Product product2 =  new Product("Samsung Galaxy", 7500.0, 2, new Date());		
//		List<Product> products = Arrays.asList(product1, product2);
//		
//		user.setProducts(products);
		
		Product product1 =  new Product("İ Phone 7", 10000.0, 3, new Date());
		product1.setUser(user);
		Product product2 =  new Product("Samsung Galaxy", 7500.0, 2, new Date());
		product2.setUser(user);
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.persist(product1);
		manager.persist(product2);
		manager.getTransaction().commit();
		
	}

}
