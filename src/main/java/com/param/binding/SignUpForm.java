package com.param.binding;

import lombok.Data;

@Data
public class SignUpForm {
	private String name;
	private String email;
	@Override
	public String toString() {
		return "SignUpForm [name=" + name + ", email=" + email + ", phno=" + phno + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	private Long phno;

}
