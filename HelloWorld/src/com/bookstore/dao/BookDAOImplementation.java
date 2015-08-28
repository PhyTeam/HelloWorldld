package com.bookstore.dao;

import java.sql.*;
import java.util.List;

import com.bookstore.model.Book;
import com.bookstore.model.Category;

public class BookDAOImplementation implements BookDAO {
	static 
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print("DKM" + e.toString());
		}
	}
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "app", "07101995");
	}
	public void closeConnection(Connection connection)
	{
		if(connection == null)
		{
			return;
		} else
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}
	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Book> findByKeyword(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}
}
