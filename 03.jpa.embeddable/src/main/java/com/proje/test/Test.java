package com.proje.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.model.Contact;
import com.proje.model.User;

public class Test {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager entityManager = factory.createEntityManager();
		
		User user = new User("Yakup", "12345", new Contact("05555", "xxx@xx.com", "xxxx.com.tr"), new Date());
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
	}

}
