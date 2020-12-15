package com.highradius.internship;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/logus")
public class logInUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public logInUser() {
		super();
	}

//logIn done
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("user");
		String passWord = request.getParameter("password");

		String flag = "";

		System.out.println("inside logIn  " + userName + " : " + passWord);

		Connection connection = null;
		ResultSet resultset = null;
		try {
			String query = "SELECT PASSWORD, user_level FROM user_details WHERE username = '" + userName + "' ;";

			connection = DataClass.initializeDatabase();
			resultset = DataClass.getDBResultSet(connection, query);
			String resString = "";
			if (!resultset.next())
				System.out.println("failed query");
			else
				resString = resultset.getString("password");

			if (passWord.equals(resString))
				flag = resultset.getString("user_level");

		} catch (ClassNotFoundException e) {
			System.out.println("Object/CLass exception in logInUser ");
			flag = "";
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Database or query exception in logInUser");
			flag = "";
			e.printStackTrace();
		}

//		sending response to front-end
		Gson gson = new Gson();
		String data = gson.toJson(flag);
		PrintWriter out = response.getWriter();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		out.print(data);
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
