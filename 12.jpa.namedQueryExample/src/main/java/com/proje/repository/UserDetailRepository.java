package com.proje.repository;

import com.proje.jpaFactory.JPAFactory;
import com.proje.jpaFactory.impl.JPAFactoryImpl;
import com.proje.model.UserDetail;

public interface UserDetailRepository {
	
	JPAFactory factory = new JPAFactoryImpl();

	boolean save(UserDetail userDetail);
	
	boolean update(UserDetail userDetail);
	
	boolean removeUser(UserDetail userDetail);
	
	UserDetail findById(Integer id);
	
	UserDetail findByUsername(String username);
	
	UserDetail findWithAddressByUsername(String username);
	
	UserDetail findWithAdvertisementsByUsername(String username);
}
