package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Book;

public interface BookRepository {

	int save(Book book);
	int update(Book book);
	Book findById(Long id);
	int deleteById(Long id);
	List<Book> findAll();
	List<Book> findByPublished(boolean published);
	List<Book> findByTitleContaining(String word);
	int deleteAll();
	
}
