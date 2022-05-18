package com.lhs.PlayLoad;



public class LoadEmail {
	
	
	public 	String email;
	public int otp;
	public String newpassword;
	
	
	
	

 public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

public LoadEmail() {
		super();
	}

public LoadEmail(String email) {
		super();
		this.email = email;
	}

public LoadEmail(int otp) {
	super();
	this.otp = otp;
}




public int getOtp() {
	return otp;
}

public void setOtp(int otp) {
	this.otp = otp;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
