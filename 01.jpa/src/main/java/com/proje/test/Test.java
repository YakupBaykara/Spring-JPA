package com.proje.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Personel;

public class Test {
		
	public static void main(String[] args) {
		
		/*
		 * Tablo oluşturmak için bu iki satır main metodunda çalıştırılır. Create
		 * modunda iken. Sonradan işlem yapmak için update moduna alınır.
		 */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");		
		EntityManager entityManager = factory.createEntityManager();		
			
//		EntityTransaction transaction = entityManager.getTransaction();
//		Personel personel = new Personel(1, "yakup", "baykara", "055555", "xxxxxx", new Date(), 2500.0);
		
		/*
		 * Persist - Find - Update, Merge - Delete işlemleri transaction içerisinde
		 * yapılır. Update modeunda iken
		 */
//		transaction.begin();
//		Persist İşlemi
//		entityManager.persist(personel);
		
//		Find İşlemi
//		Personel foundPersonel = entityManager.find(Personel.class, 1);
		
//		Merge İşlemi
//		foundPersonel.setBirthDate(new Date());
//		foundPersonel.setSalary(1500.0);
//		entityManager.merge(foundPersonel);
		
//		Delete İşltemi
//		entityManager.remove(foundPersonel);
		
//		transaction.commit();
		
	}
	
}
