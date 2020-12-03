package com.highradius.internship.SearchNpage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.internship.DataClass;

@WebServlet("/search")

public class SearchData extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchData() throws ClassNotFoundException {
    	super();
    }

	
    
//    try to implement fast searching
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int orderID=0,customerID=0,orderAmt=0;
		
		String orderDate="",customerName="",notes="";
		
		

			

		
		
	    
		Connection connection = null;
		String query="";
		try {
			
	
			
			orderID = Integer.parseInt(request.getParameter("orderID"));
			customerID = Integer.parseInt(request.getParameter("customerID"));
			orderAmt = Integer.parseInt(request.getParameter("orderAmt"));
			
			
			
			orderDate = request.getParameter("orderDate");
			customerName = request.getParameter("customerName");
			notes = request.getParameter("notes");
			
//			change it to correct time format
			orderDate = "2020-09-20 00:00:00";
			

			
			connection = DataClass.initializeDatabase();
			query="INSERT INTO `order_details` ( `Order_ID`, `Order_Date`, `Customer_Name`, `Customer_ID`, `Order_Amount`, `Notes` )" + 
					"VALUES ( "+orderID+", "+
					" \'"+orderDate+"\' ,"+
					" \'"+customerName+"\' ,"+
					customerID+", "+orderAmt+", \'"+
					notes+"\' ) ; " ;
			
			DataClass.runQuery(connection, query);
			DataClass.closeDBConnection(connection);
			System.out.println(query);
		 
			System.out.println("succeessssssssss");
			
			
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
	doGet(request, response);
		
	}
	
	

}
