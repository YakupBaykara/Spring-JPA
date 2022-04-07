package com.proje.bookRepository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.proje.bookRepository.BookRepository;
import com.proje.model.Book;

public class BookRepositoryImpl implements BookRepository{

//	BookRepository de tanımlandığı için buna gerek kalmadı.	
//	private JPAFactory jpaFactory = new JPAFactoryImpl();
	
//	private kelimesi static değerler için kullanılmaz.	
	EntityManager entityManager = jpaFactory.getEntityManager();
	EntityTransaction transaction = jpaFactory.getEntityTransaction();

	@Override
	public void save(Book book) {
		
		this.transaction.begin();
		this.entityManager.persist(book);
		this.transaction.commit();
	}

	@Override
	public void delete(Book book) {
		
		this.transaction.begin();
		this.entityManager.remove(book);
		this.transaction.commit();	
	}

	@Override
	public Book find(int id) {
		
		Book book = this.entityManager.find(Book.class, id);
		
		if(book != null)
			return book;
		return null;
	}

	@Override
	public Book update(Book book) {
		
		Book updatedBook = this.entityManager.merge(book);
		return updatedBook;
	}

}
