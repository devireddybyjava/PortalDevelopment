package com.param.binding;


public class LoginForm {

	private String email;
	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", Password=" + Password + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	private String Password;
}
