package com.proje.test;

import java.util.Calendar;
import java.util.Date;

import com.proje.bookRepository.BookRepository;
import com.proje.bookRepository.impl.BookRepositoryImpl;
import com.proje.model.Book;

public class Test {

	public static void main(String[] args) {		
		
		BookRepository bookRepository = new BookRepositoryImpl();
		
		Book book = new Book(100, "Harry Potter", 250, "Aksiyon - Macera", "Yakup", createCustomDate(12, 03, 2022));
		Book book2 = new Book(101, "Yüzüklerin Efendisi", 300, "Bilim Kurgu", "Yakup", createCustomDate(12, 03, 2022));
		
		bookRepository.save(book);
		bookRepository.save(book2);
	}
	
	public static Date createCustomDate(int day, int month, int year) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		
		return calendar.getTime();
	}

}
