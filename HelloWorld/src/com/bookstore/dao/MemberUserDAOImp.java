package com.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.model.MemberUser;

public class MemberUserDAOImp implements MemberUserDAO{

	static 
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.print(e.toString());
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		String DBName = "root";
		String DBPwd = "";
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/tmapp", DBName, DBPwd);
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
	public MemberUser getMemberUserById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM `tmapp`.`user` WHERE `user_name` = ?");
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement.toString());
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.toString());
			if(resultSet.next())
			{
				System.out.println(resultSet.toString());
				return new MemberUser(resultSet.getString("user_name"),resultSet.getString("password"),
						resultSet.getString("fname"));
			} else return null;
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		closeConnection(conn);
		return null;
	}

	@Override
	public void addMemberUser(MemberUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMemberUser(MemberUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMemberUser(MemberUser user) {
		// TODO Auto-generated method stub
		
	}

}
