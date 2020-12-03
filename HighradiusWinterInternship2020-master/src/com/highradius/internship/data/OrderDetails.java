package com.highradius.internship.data;

public class OrderDetails {

private int Order_Id,company_Id,id;
	

	private String Company_Name,Approval_status,Approved_By,Notes,Order_Date,Order_amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_Id() {
		return Order_Id;
	}

	public void setOrder_Id(int order_Id) {
		Order_Id = order_Id;
	}

	public int getCompany_Id() {
		return company_Id;
	}

	public void setCompany_Id(int customer_Id) {
		this.company_Id = customer_Id;
	}

	public String getOrder_amount() {
		return Order_amount;
	}

	public void setOrder_amount(String amount) {
		Order_amount = amount;
	}

	public String getCustomer_Name() {
		return Company_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Company_Name = customer_Name;
	}

	public String getApproval_status() {
		return Approval_status;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}

	public void setApproval_status(String approval_status) {
		Approval_status = approval_status;
	}

	public String getApproved_By() {
		return Approved_By;
	}

	public void setApproved_By(String approved_By) {
		Approved_By = approved_By;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public String getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(String order_Date) {
		Order_Date = order_Date;
	}
	
	
	
}
