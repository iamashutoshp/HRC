package com.highradius.internship.data;

public class UserData {

	
private String userName,passWord,level;
	
	private int userId;
	
	
	
	boolean status;
	
	UserData(String user,String pass){
		userName = user;
		passWord = pass;
		level="";
		userId=0;
		status=true;
		
	}
	



	public static String toString(UserData ud) {
		return "UserDetails : [ \n"+
				"{ userId : "+ud.userId+" }\n"+
				"{ userName : "+ud.userName+" }\n"+
				"{ passWord : "+ud.passWord+" }\n"+
				"{ level : "+ud.level+" }\n"+
				"{ status : "+ud.status+" }\n";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
}
