package com.proje.tes;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Student;
import com.proje.model.University;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		University university = new University("İnönü Üniversitesi");
		University university2 = new University("Fırat Üniversitesi");
		University university3 = new University("İstanbul Üniversitesi");
		
		Student student = new Student("Yakup", "BAYKARA", new Date());
		student.addUniversity(university);
		student.addUniversity(university2);
		
		Student student2 = new Student("Yusuf", "BAYKARA", new Date());
		student2.addUniversity(university3);
		student2.addUniversity(university2);
		
		transaction.begin();
		manager.persist(student);
		manager.persist(student2);
		manager.persist(university);
		manager.persist(university2);
		manager.persist(university3);
		transaction.commit();
	}

}
