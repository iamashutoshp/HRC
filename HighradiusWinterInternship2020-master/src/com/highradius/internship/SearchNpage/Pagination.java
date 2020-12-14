package com.highradius.internship.SearchNpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.internship.DataClass;
import com.highradius.internship.logInUser;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import com.highradius.internship.data.*;


@WebServlet("/paging")



// implement client side paging
public class Pagination extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagination() throws ClassNotFoundException {
    	super();
    }

	
    
//    try to implement paging
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pageNo = Integer.parseInt(request.getParameter("pNo"))-1;
		String level = request.getParameter("LvL");
		 
//		System.out.println(level);
		ArrayList<OrderDetails> data = null;
		Connection connection = null;
		String query="";
		try {
			connection = DataClass.initializeDatabase();
			
			switch (level) {
			case "Level 2":
				query = "SELECT * FROM `order_details` WHERE `Order_Amount` <= '50000' AND `Order_Amount` > '10000' ;"  ;
				data=levelBasedData.Level2Page(connection, level, pageNo,query);
			break;	
			case "Level 3":
				query = "SELECT * FROM `order_details` WHERE `Order_Amount` > '50000' ;"  ;
				data=levelBasedData.Level3Page(connection, level, pageNo,query);
			break;
			default:
				query = "SELECT * FROM order_details ;"  ;
				data=levelBasedData.Level1Page(connection, level, pageNo,query);
				break;
			}
			
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
		
		
		int sz=0;
		if(data.size()%10 == 0)
			sz=data.size()/10;
		else
			sz=data.size()/10 + 1;
		
		
		
		
		
		
		ArrayList<OrderDetails> rowData = new ArrayList<>();
		
		
		for(int k=0;k<10 && (k+10*pageNo)<data.size();k++)
			rowData.add(data.get(k+10*pageNo));
		
		Data res = new Data(rowData, pageNo+1, sz);
		
		
		
		Gson gson = new Gson();
		String send = gson.toJson(res);
		 
		 
		 
		 PrintWriter out = response.getWriter();
		 
		 
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 
		 
		 out.print(send);
		 out.flush();
	}

		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
		
	}
	
	

}

class Data{
	ArrayList<OrderDetails> data;
	int pageNo, totalSize;
	Data(ArrayList<OrderDetails> d, int pno, int size){
		data=d;
		pageNo = pno;
		totalSize =size;
	}
}
