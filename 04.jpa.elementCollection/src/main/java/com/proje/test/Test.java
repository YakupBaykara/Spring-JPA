package com.proje.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.model.Personel;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager entityManager = factory.createEntityManager();
		
		Personel personel = new Personel("Yakup", "Baykara", new Date());
		List<String> phoneNumbers = Arrays.asList("053333", "042222", "05555");	
		personel.setPhoneNumbers(phoneNumbers);
		
		Personel personel2 = new Personel("Yusuf", "Baykara", new Date());
		List<String> phoneNumbers2 = new ArrayList<String>();
		phoneNumbers2.add("055555");
		phoneNumbers2.add("054444");		
		personel2.setPhoneNumbers(phoneNumbers2);		
	
		entityManager.getTransaction().begin();
		entityManager.persist(personel);
		entityManager.persist(personel2);
		entityManager.getTransaction().commit();
					
	}

}
