package com.proje.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Adress;
import com.proje.model.User;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		User user1 = new User("Yakup", "Baykara", new Date());
		Adress adress1 = new Adress("Koçibey", "İpekyolu", "VAN", 65);				
		user1.getAdresses().add(adress1);
		user1.getAdresses().add(new Adress("Yakınkent", "Yeşilyurt", "MALATYA", 44));
		
		User user2 = new User("Yusuf", "Baykara", new Date());
		Adress adress2 = new Adress("Yakınkent", "Yeşilyurt", "MALATYA", 44);
		user2.getAdresses().add(adress2);
		
		transaction.begin();
		manager.persist(user1);
		manager.persist(user2);
		transaction.commit();
		
	}	
}
