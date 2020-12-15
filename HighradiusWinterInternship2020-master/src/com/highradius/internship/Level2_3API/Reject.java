package com.highradius.internship.Level2_3API;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.internship.DataClass;



@WebServlet("/reject")

public class Reject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String level = request.getParameter("Lvl");
		String userName = level.equals("Level 2") ? "Laura Smith " : "Matthew Vance";
		
		System.out.println("in reject : \n" +orderId+"\n"+level+"\n"+userName);
		Connection connection = null;
		String query="";
		try {
			connection = DataClass.initializeDatabase();
			query="UPDATE `order_details` SET `Approval_Status` = 'Rejected' , `Approved_By` = \'"+userName+"\' " + 
					"WHERE `Order_ID` = \'"+orderId+"\' ;";
			
			
			DataClass.runQuery(connection, query);
			
			DataClass.closeDBConnection(connection);
			System.out.println(query);
		 
			System.out.println("successfully rejected");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
