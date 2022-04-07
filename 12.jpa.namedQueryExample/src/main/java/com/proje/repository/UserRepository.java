package com.proje.repository;

import java.util.List;
import com.proje.jpaFactory.JPAFactory;
import com.proje.jpaFactory.impl.JPAFactoryImpl;
import com.proje.model.User;
public interface UserRepository {
	
	JPAFactory factory = new JPAFactoryImpl();
	
	boolean save(User user);
	
	boolean update(User user);
	
	boolean remove(User user);
	
	User findById(Integer id);
	
	User findByUsername(String username);
	
	User findWithUserDetailByUsername(String username);
	
	List<User> findAll();
	
	int findCount();
	
	User findWithUserInfoByUsername(String username);
}
