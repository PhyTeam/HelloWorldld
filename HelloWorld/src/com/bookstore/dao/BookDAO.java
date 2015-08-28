package com.bookstore.dao;

import java.util.List;

import com.bookstore.model.Book;
import com.bookstore.model.Category;

public interface BookDAO {
	public List<Book> findAllBook();
	public List<Category> findAllCategory();
	public List<Book> findByKeyword(long id);
	public void insert(Book book);
	public void delete(long id);
	public void update(Book book);
}
