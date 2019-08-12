package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
//		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
//		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
//		String driver = "com.mysql.cj.jdbc.Driver";
		String driver = "com.mysql.jdbc.Driver";

		System.out.println("\n- - - - - - - Connecting... - - - - - - - - - - ");
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);

			out.println("<<< SUCCESS! >>>");
			if (myConnection.isValid(0)) {
				out.println("Connection to database is valid.");
			}

			myConnection.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
