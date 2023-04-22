package com.param.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.param.binding.LoginForm;
import com.param.binding.SignUpForm;
import com.param.binding.UnlockForm;
import com.param.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginAccount(@ModelAttribute("loginForm") LoginForm Login,Model model) {
		
		String login=userService.loginPage(Login);
		if(login.contains("Successfully logged into the Account"))
		{
			return "redirect:/dashboard";
		}
		return "login";
		
	}
	
	
	
	@GetMapping("/signUp")
	public String singUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "signUp";
	}
	@PostMapping("/signUp")
	public String handleSignUp(@ModelAttribute("user") SignUpForm signup,Model model) {
		boolean status=userService.signUpPage(signup);
		if(status) {
			model.addAttribute("succMsg","Account created, Check Your Email");
			
		}else {
			model.addAttribute("errMsg","Problem Occured");
		}
		
		return "signUp";
		
	}
	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email, Model model ) {
		UnlockForm unlockObj=new UnlockForm();
		unlockObj.setEmail(email);
		model.addAttribute("unlock", unlockObj);
		return "unlock";
	}
	@PostMapping("/unlock")
	public String unlockAccount(@ModelAttribute("unlock") UnlockForm unlock, Model model) {
		System.out.println(unlock);
		if(unlock.getNewPwd()==unlock.getCnfmPwd()) {
			userService.unlockPage(unlock);
		}else {
			model.addAttribute("errMsg", "New Password and Confirm Password must and should be same");
		}
		return "unlock";
		
	}
	
	
	
	
	@GetMapping("/forgot")
	public String forgotPage() {
		
		return "forgotPwd";
	}
}
