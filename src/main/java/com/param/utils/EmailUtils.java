package com.param.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean sendEmail(String to, String subject, String body) {
		boolean isSent=false;
		try {
			MimeMessage mimeMsg=mailsender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMsg,true);
			
			helper.setSubject(subject);
		helper.setText(body,true);
		helper.setTo(to);
		//helper.addAttachment("Plans-info", f);
		mailsender.send(mimeMsg);
			isSent=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSent;

}
}
