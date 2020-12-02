package com.highradius.internship.Level1API;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.internship.DataClass;



@WebServlet("/edit")
public class EDIT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public EDIT() throws ClassNotFoundException {
	    	super();
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
	    
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			update Edit order query in database
			
			
			String id = "";
			int amt = 0;
			String notes="";

			
			
			Connection connection = null;
			String query="";
			try {
				id = request.getParameter("id");
				amt = Integer.parseInt(request.getParameter("at"));
				notes=request.getParameter("nt");
				
				
				query="UPDATE `order_details` \r\n" + 
						"SET `Order_Amount` = "+amt+" , `Notes` =" +notes+" WHERE `Order_ID` = "+id+" ;";
				
				
				connection = DataClass.initializeDatabase();
				DataClass.runQuery(connection, query);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
			
			
		
			
			
			
			
		}
	//
			
			
			
			
			


		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			

		}
		

}
