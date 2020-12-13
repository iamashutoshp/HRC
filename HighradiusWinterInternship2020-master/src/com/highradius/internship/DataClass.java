package com.highradius.internship;
import java.util.*;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

public class DataClass {
	
	

	public static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException 
	    { 
	        // Initialize all the information regarding 
	        // Database Connection
	        
	        String dbDriver = "com.mysql.jdbc.Driver"; 
	        String dbURL = "jdbc:mysql:// localhost:3306/"; 
	        String dbName = "winter_internship"; 
	        String dbUsername = "root"; 
	        String dbPassword = "ashu"; 
	        
	        
	  
	        Class.forName(dbDriver); 
	        Connection con = DriverManager.getConnection(dbURL + dbName, 
	                                                     dbUsername,  
	                                                     dbPassword);
//	        System.out.println("success");
	        return con; 
	    } 
	
//	to get result set
	public static ResultSet getDBResultSet(Connection conn, String query) {
		ResultSet rs = null;
		if (conn != null) {
			PreparedStatement st=null;
			try {
				st = conn.prepareStatement(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("--->2.1");
			try {
				rs = st.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("--->2.2");
		}
		return rs;
	}
	
//	 to run an update query such as update, delete
	
	public static void runQuery(Connection conn, String query) throws SQLException {
		if (null != conn) {
			PreparedStatement st = conn.prepareStatement(query);
			st.executeUpdate();
		} else {
			System.out.println("Query execution failed!");
		}
	}
	
//	 close an opened PreparedStatement if any
	
	public static void closePreparedStatement(PreparedStatement ps)	throws SQLException {
		if (null != ps) {
			ps.close();
		}
	}
	
//	closes an open resultSet
	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (null != rs) {
			rs.close();
		}
	}
	
	
// closes database connection
	public static void closeDBConnection(Connection conn) throws SQLException {
		if (null != conn) {
			conn.close();
		}
	}

		
	
}
