package com.param.service;

import com.param.binding.DashboardResponse;
import com.param.binding.LoginForm;
import com.param.binding.SignUpForm;
import com.param.binding.UnlockForm;

public interface UserService {
	
	public String loginPage(LoginForm login);
	
	public boolean signUpPage(SignUpForm signup);
	
	public boolean unlockPage(UnlockForm unlock);
	
	public String forgotPage(String email);	
	
}
