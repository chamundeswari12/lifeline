package com.lhs.PlayLoad;

public class PasswordChange {
	public PasswordChange(String newpassword, String oldpassword) {
		super();
		this.newpassword = newpassword;
		this.oldpassword = oldpassword;
	}
	public PasswordChange()
	{
		
	}
	private String newpassword;
	private String oldpassword;
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

}
