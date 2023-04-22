package com.param.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashPage() {
		
		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	public String addEnquiryPage() {
		
		return "add-enquiry";
	}
	
	@GetMapping("/enquiries")
	public String viewEnquiryPage() {
		
		return "view-enquiries";
	}

}
