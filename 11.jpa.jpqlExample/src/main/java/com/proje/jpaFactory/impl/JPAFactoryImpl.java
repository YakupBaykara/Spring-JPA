package com.proje.jpaFactory.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.jpaFactory.JPAFactory;

public class JPAFactoryImpl implements JPAFactory{
	
	private EntityManager manager = null;
	
	@Override
	public EntityManager getEntityManager() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		this.manager = factory.createEntityManager();		
		return manager;
	}

	@Override
	public EntityTransaction getEntityTransaction() {
		
		EntityTransaction transaction = this.manager.getTransaction();
		return transaction;
	}

}
