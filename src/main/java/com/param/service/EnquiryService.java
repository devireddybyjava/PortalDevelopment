package com.param.service;

import java.util.List;

import com.param.binding.EnquiryForm;
import com.param.binding.EnquirySearchCriteria;

public interface EnquiryService {
    
	public List<String> getCourseNames();
	
	public List<String> getEnqStatus();
	public String getDashBoardPage(Integer userID);
	public String addEnquiries(EnquiryForm addenquiry);
	public List<EnquiryForm> getEnquiries(Integer userID, EnquirySearchCriteria enqurySearch);
	public EnquiryForm getEnquiryForm(Integer Enquiry_ID);
}
