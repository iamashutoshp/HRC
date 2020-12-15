package com.highradius.internship.Level1API;

import javax.servlet.http.HttpServlet;

import com.highradius.internship.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/add")
public class ADD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ADD() throws ClassNotFoundException {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int orderID = 0, customerID = 0, orderAmt = 0;

		String orderDate = "", customerName = "", notes = "";

		Connection connection = null;
		String query = "";

		Boolean success = false;

		try {

			orderID = Integer.parseInt(request.getParameter("orderID"));
			customerID = Integer.parseInt(request.getParameter("customerID"));
			orderAmt = Integer.parseInt(request.getParameter("orderAmt"));

			orderDate = request.getParameter("orderDate");
			customerName = request.getParameter("customerName");
			notes = request.getParameter("notes");

			String isOrderPresent = "SELECT * FROM order_details WHERE Order_ID = " + orderID + " ;";
			connection = DataClass.initializeDatabase();
			ResultSet resultset = DataClass.getDBResultSet(connection, isOrderPresent);
			boolean path = resultset.next();

			String approvalStatus = "";
			if (!path && !(orderID == 0 || orderAmt == 0 || customerID == 0 || orderDate.equals("")
					|| customerName.equals(""))) {
				System.out.println("order does not exsist so add it");

				if (orderAmt <= 10000) {
					approvalStatus = "Approved";
					query = "INSERT INTO `order_details` ( `Order_ID`, `Order_Date`, `Customer_Name`, `Customer_ID`, `Order_Amount`, `Notes` , `Approval_Status` , `Approved_By` )"
							+ "VALUES ( " + orderID + ", " + " \'" + orderDate + "\' ," + " \'" + customerName + "\' ,"
							+ customerID + ", " + orderAmt + ", \'" + notes + "\' ," + " \'" + approvalStatus + "\' ,"
							+ " \'David Lee\') ;";

					System.out.println(query);
				} else {
					approvalStatus = "Awaiting Approval";

					query = "INSERT INTO `order_details` ( `Order_ID`, `Order_Date`, `Customer_Name`, `Customer_ID`, `Order_Amount`, `Notes` , `Approval_Status` )"
							+ "VALUES ( " + orderID + ", " + " \'" + orderDate + "\' ," + " \'" + customerName + "\' ,"
							+ customerID + ", " + orderAmt + ", \'" + notes + "\' ," + " \'" + approvalStatus
							+ "\' ) ;";

				}

				System.out.println(query);
				DataClass.runQuery(connection, query);
				DataClass.closeResultSet(resultset);
				DataClass.closeDBConnection(connection);

				success = true;
				System.out.println("succeessssssssss");
			} else {
				success = false;
				System.out.println("sorry an order ID Already exists");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

// sending success or failure response to front-end		

		Gson gson = new Gson();
		String data = gson.toJson(success);
		PrintWriter out = response.getWriter();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		out.print(data);
		out.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
