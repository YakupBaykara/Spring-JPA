package com.proje.repository;

import java.util.List;

import com.proje.jpaFactory.JPAFactory;
import com.proje.jpaFactory.impl.JPAFactoryImpl;
import com.proje.model.Education;

public interface EducationRepository {
	
	JPAFactory factory = new JPAFactoryImpl();
	
	boolean save(Education education);
	
	boolean update(Education education);
	
	boolean remove(Education education);
	
	Education findById(Integer id);
	
	List<Education> findAll();
	
	Education findWithAdvertisementById(Integer id);
}
