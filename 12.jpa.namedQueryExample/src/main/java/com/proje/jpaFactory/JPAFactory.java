package com.proje.jpaFactory;

import javax.persistence.EntityManager;

public interface JPAFactory {

	EntityManager getEntityManager();
	
}
