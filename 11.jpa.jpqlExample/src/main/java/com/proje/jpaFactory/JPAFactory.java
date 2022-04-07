package com.proje.jpaFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface JPAFactory {

	EntityManager getEntityManager();
	
	EntityTransaction getEntityTransaction();
}
