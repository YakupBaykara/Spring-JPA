package com.proje.bookRepository;

import com.proje.jpaFactory.JPAFactory;
import com.proje.jpaFactory.impl.JPAFactoryImpl;
import com.proje.model.Book;

public interface BookRepository {

	// Interface içinde tanımlanan değişkenler final ve static olur.
	JPAFactory jpaFactory = new JPAFactoryImpl();
	
	void save(Book book);
	
	void delete(Book book);
	
	Book find(int id);
	
	Book update(Book book);
}
