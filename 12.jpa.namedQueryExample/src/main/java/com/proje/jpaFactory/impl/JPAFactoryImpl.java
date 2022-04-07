package com.proje.jpaFactory.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.jpaFactory.JPAFactory;

public class JPAFactoryImpl implements JPAFactory{
	
	@Override
	public EntityManager getEntityManager() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
		return factory.createEntityManager();
	}

}
