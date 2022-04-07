package com.proje.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.model.Department;
import com.proje.model.Employee;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Department department = new Department("Yazilim", 2500.0, 4000.0);
		Department department2 = new Department("Tester", 2000.0, 3500.0);
		
		Employee employee1 = new Employee( "Yakup", "BAYKARA", new Date(), 3000.0);
		employee1.setDepartment(department);

				
		
		Employee employee2 = new Employee( "Yusuf", "BAYKARA", new Date(), 3500.0);
		employee2.setDepartment(department2);
		
		transaction.begin();
//		Department sınıfına employess değişkeni eklendi ve mappedBy özelliği verildi. aşağıdaki işlemlere gerek kalmadı.
//		manager.persist(department);
//		manager.persist(department2);
		manager.persist(employee1);
		manager.persist(employee2);
		transaction.commit();
	}

}
