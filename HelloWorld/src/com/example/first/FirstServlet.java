package com.example.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.NonWritableChannelException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bookstore.dao.*;
import com.bookstore.model.MemberUser;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    	// Add some stuff here
    	// 
    	System.out.print(getServletInfo());
    	System.out.print("Servlet has been created at " + this.getServletInfo());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO:
		response.setContentType("text/html");
		
		if(request.getParameter("username") != null)
		{
			PrintWriter writer = response.getWriter();
			writer.print("Hello world " + request.getParameter("username"));
			// Fetching from db
			MemberUserDAO dao = new MemberUserDAOImp();
			try {
				MemberUser user = dao.getMemberUserById(request.getParameter("username"));
				if(user != null)
					writer.println("User name is " + user.getFname() + " Your password has " + user.getPassword().length() 
						+ " characters.");
				else writer.println("There no user like you.");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("some error");
				e.printStackTrace();
			}
			
			
		} else {
			String nextJsp = "/loginform.html";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
