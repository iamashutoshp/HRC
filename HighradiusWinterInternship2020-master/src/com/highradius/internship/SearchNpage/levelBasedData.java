package com.highradius.internship.SearchNpage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.highradius.internship.DataClass;
import com.highradius.internship.data.OrderDetails;

public class levelBasedData {

	
	static ArrayList<OrderDetails> Level1Page(Connection connection,String level,int pageNo,String query) throws SQLException {
		
// fetching requirements for Level 1 users requested data
		ArrayList<OrderDetails> data = new ArrayList<>();
		ResultSet resultset = DataClass.getDBResultSet(connection, query);
		int i = 0;
		while(resultset.next()) {
			OrderDetails details = new OrderDetails();
			details.setId(i++);
			String val="";
			val=resultset.getString("Approval_Status");
			details.setApproval_status(val==null?" ":val);
			
			val=resultset.getString("Approved_By");
			details.setApproved_By(val==null?" ":val);
			
			details.setCompany_Id(Integer.parseInt(resultset.getString("Customer_ID")));
			details.setCompany_Name(resultset.getString("Customer_Name"));
			
			val=resultset.getString("Notes");
			details.setNotes(val==null?" ":val);
			details.setOrder_amount(resultset.getString("Order_Amount"));
			
			
		    
			String dateData[] = (resultset.getString("Order_Date").trim()).split(" ");
			
			String formatDate[] = (dateData[0]).split("-");
			String date = formatDate[2]+"/"+formatDate[1]+"/"+formatDate[0];
			details.setOrder_Date(date);
			
		    
		    
			details.setOrder_Id(Integer.parseInt(resultset.getString("Order_ID")));
			
			data.add(details);
			
		}
		DataClass.closeResultSet(resultset);
		
		return data;
		
	}
	
	 static ArrayList<OrderDetails> Level2Page(Connection connection,String level,int pageNo,String query) throws SQLException {

// fetching requirements for Level 2 users requested data
			ArrayList<OrderDetails> data = new ArrayList<>();
			ResultSet resultset = DataClass.getDBResultSet(connection, query);
			int i = 0;
			while(resultset.next()) {
				OrderDetails details = new OrderDetails();
				details.setId(i++);
				String val="";
				val=resultset.getString("Approval_Status");
				details.setApproval_status(val==null?" ":val);
				
				val=resultset.getString("Approved_By");
				details.setApproved_By(val==null?" ":val);
				
				details.setCompany_Id(Integer.parseInt(resultset.getString("Customer_ID")));
				details.setCompany_Name(resultset.getString("Customer_Name"));
				
				val=resultset.getString("Notes");
				details.setNotes(val==null?" ":val);
				details.setOrder_amount(resultset.getString("Order_Amount"));
				
				
				String dateData[] = (resultset.getString("Order_Date").trim()).split(" ");
				
				String formatDate[] = (dateData[0]).split("-");
				String date = formatDate[2]+"/"+formatDate[1]+"/"+formatDate[0];
				details.setOrder_Date(date);
				
				details.setOrder_Id(Integer.parseInt(resultset.getString("Order_ID")));
				
				data.add(details);
				
			}
			DataClass.closeResultSet(resultset);
			
			return data;
		
	}
	
	 static ArrayList<OrderDetails> Level3Page(Connection connection,String level,int pageNo,String query) throws SQLException {

// fetching requirements for Level 3 users requested data
			ArrayList<OrderDetails> data = new ArrayList<>();
			ResultSet resultset = DataClass.getDBResultSet(connection, query);
			int i = 0;
			while(resultset.next()) {
				OrderDetails details = new OrderDetails();
				details.setId(i++);
				String val="";
				val=resultset.getString("Approval_Status");
				details.setApproval_status(val==null?" ":val);
				
				val=resultset.getString("Approved_By");
				details.setApproved_By(val==null?" ":val);
				
				details.setCompany_Id(Integer.parseInt(resultset.getString("Customer_ID")));
				details.setCompany_Name(resultset.getString("Customer_Name"));
				
				val=resultset.getString("Notes");
				details.setNotes(val==null?" ":val);
				details.setOrder_amount(resultset.getString("Order_Amount"));
				
				String dateData[] = (resultset.getString("Order_Date").trim()).split(" ");
				
				String formatDate[] = (dateData[0]).split("-");
				String date = formatDate[2]+"/"+formatDate[1]+"/"+formatDate[0];
				details.setOrder_Date(date);
				
				details.setOrder_Id(Integer.parseInt(resultset.getString("Order_ID")));
				
				data.add(details);
				
			}
			DataClass.closeResultSet(resultset);
			
			return data;
		
	}
	
}
