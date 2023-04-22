package com.param.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Table(name="AIT_USER_DTLS")
public class UserDtlsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	private String name;
	private String email;
	private Long phno;
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAcc_status() {
		return acc_status;
	}

	public void setAcc_status(String acc_status) {
		this.acc_status = acc_status;
	}

	public List<StudentEnqEntity> getStudentenq() {
		return studentenq;
	}

	public void setStudentenq(List<StudentEnqEntity> studentenq) {
		this.studentenq = studentenq;
	}

	private String pwd;
	private String acc_status;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<StudentEnqEntity> studentenq;
}
