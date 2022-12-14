package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Book;

@Repository
public class JdbcBookRepository implements BookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Book book) {
		return jdbcTemplate.update("INSERT INTO books (title, description, published) VALUES (?,?,?)",
				new Object[] { book.getTitle(), book.getDescription(), book.isPublished() });
	}

	@Override
	public int update(Book book) {
		return jdbcTemplate.update("UPDATE books SET title=?, description=?, published=? WHERE id=?",
				new Object[] { book.getTitle(), book.getDescription(), book.isPublished(), book.getId() });
	}

	@Override
	public Book findById(Long id) {
		try {
			Book book = jdbcTemplate.queryForObject("SELECT * FROM books WHERE id=?",
					BeanPropertyRowMapper.newInstance(Book.class), id);
			return book;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
	}

	@Override
	public List<Book> findAll() {
		return jdbcTemplate.query("SELECT * from books", BeanPropertyRowMapper.newInstance(Book.class));
	}

	@Override
	public List<Book> findByPublished(boolean published) {
		return jdbcTemplate.query("SELECT * from books WHERE published=?", 
				BeanPropertyRowMapper.newInstance(Book.class), published);
	}

	@Override
	public List<Book> findByTitleContaining(String word) {
		String query = "SELECT * from books WHERE title ILIKE '%" + word + "%'";
	    return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Book.class));
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("DELETE from tutorials");
	}

}
