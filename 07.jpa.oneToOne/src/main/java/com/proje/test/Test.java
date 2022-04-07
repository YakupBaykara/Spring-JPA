package com.proje.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Adress;
import com.proje.model.Customer;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Customer customer = new Customer("Yakup", "Baykara", new Date());
		Adress adress1 = new Adress("Koçibey", "İpekyolu", "VAN", 65);
		customer.setAdress(adress1);

		transaction.begin();
		manager.persist(customer);
		manager.persist(adress1);
		transaction.commit();
		
	}	
}
