package com.param.binding;

import lombok.Data;

@Data
public class UnlockForm {
	
	private String email;
	private String tempPwd;
	private String newPwd;
	private String CnfmPwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTempPwd() {
		return tempPwd;
	}
	@Override
	public String toString() {
		return "UnlockForm [email=" + email + ", tempPwd=" + tempPwd + ", newPwd=" + newPwd + ", CnfmPwd=" + CnfmPwd
				+ "]";
	}
	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getCnfmPwd() {
		return CnfmPwd;
	}
	public void setCnfmPwd(String cnfmPwd) {
		CnfmPwd = cnfmPwd;
	}

}
