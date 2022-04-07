package com.proje.repository;

import java.util.List;

import com.proje.jpaFactory.JPAFactory;
import com.proje.jpaFactory.impl.JPAFactoryImpl;
import com.proje.model.Advertisement;

public interface AdvertisementRepository {
	
	JPAFactory jpaFactory = new JPAFactoryImpl();

	boolean save(Advertisement advertisement);
	
	boolean update(Advertisement advertisement);
	
	boolean remove(Advertisement advertisement);
	
	Advertisement finById(Integer id);
	
	List<Advertisement> findByUsername(String username);
	
	List<Advertisement> findAll();
	
	List<Advertisement> findSpecificRange(int fistResult, int maxResult);
}
