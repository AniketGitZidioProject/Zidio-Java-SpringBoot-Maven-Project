package com.example.job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.EmailRequest;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender; 
	
	public String sendEmail(EmailRequest request) {
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(request.getTo());
			message.setSubject(request.getSubject());
			message.setText(request.getBody());
			mailSender.send(message);
			return "Email sent Successfull!!!";
			
		}catch (Exception e) {
			//TODO:handle exception
			return "Failed to send Email!";
		}
	}

}
