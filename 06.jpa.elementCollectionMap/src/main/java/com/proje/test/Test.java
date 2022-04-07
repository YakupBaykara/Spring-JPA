package com.proje.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Personel;
import com.proje.util.PhoneType;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Personel personel =  new Personel("Yakup", "BAYKARA", new Date());
		personel.getPhoneNumbers().put(PhoneType.CEP, "0555555");
		personel.getPhoneNumbers().put(PhoneType.EV, "04322222");
		personel.getPhoneNumbers().put(PhoneType.IS, "04322222");
				
		transaction.begin();
		manager.persist(personel);
		transaction.commit();
	}

}
