package com.highradius.internship.SearchNpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.internship.DataClass;
import com.highradius.internship.data.OrderDetails;

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
		ArrayList<OrderDetails> data = new ArrayList<>();
		Connection connection = null;
		String query="";
		
		int pageNo = Integer.parseInt(request.getParameter("pNo"))-1;
		int search = Integer.parseInt(request.getParameter("s")); 
		try {
			connection = DataClass.initializeDatabase();
			query = "SELECT * FROM order_details ;"  ;
			
			query = "SELECT * FROM order_details WHERE Order_ID LIKE \'"+search+"%\' ;" ;
			ResultSet resultset = DataClass.getDBResultSet(connection, query);
			int i = 0;
			if (resultset != null) {
			do {
				OrderDetails details = new OrderDetails();
				details.setId(i++);
				
				details.setApproval_status(resultset.getString("Approval_Status"));
				details.setApproved_By(resultset.getString("Approved_By"));
				
				details.setCompany_Id(Integer.parseInt(resultset.getString("Customer_ID")));
				details.setCompany_Name(resultset.getString("Customer_Name"));
				
				details.setNotes(resultset.getString("Notes"));
				details.setOrder_amount(resultset.getString("Order_Amount"));
				
				details.setOrder_Date(resultset.getString("Order_Date"));
				details.setOrder_Id(Integer.parseInt(resultset.getString("Order_ID")));
				
				data.add(details);
				
			}while(resultset.next());
			DataClass.closeResultSet(resultset);
			 DataClass.closeDBConnection(connection);
			System.out.println(query);
		 
			System.out.println("succeessssssssss");
			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int sz=0;
		if(data.size()%10 == 0)
			sz=data.size()/10;
		else
			sz=data.size()/10 + 1;
		
		
		
		
		
		
		ArrayList<OrderDetails> rowData = new ArrayList<>();
		
		
		for(int k=0;k<10 && (k+10*pageNo)<data.size();k++)
			rowData.add(data.get(k+10*pageNo));
		
		Data res ;
		System.out.println(data);
		if(data.isEmpty()||pageNo+1>sz)
			res = new Data(rowData, 0, 0);
		else
			res = new Data(rowData, pageNo+1, sz);
		
		Gson gson = new Gson();
		String send = gson.toJson(res);
		 
		 
		 
		 PrintWriter out = response.getWriter();
		 
		 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 
		 
		 out.print(send);
		 out.flush();

				
		
	}
//
		
		
		
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
		
	}
	
	

}
