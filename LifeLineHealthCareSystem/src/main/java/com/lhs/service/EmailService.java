package com.lhs.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendOtpMessage(String to, String subject, String message) throws MessagingException {
		
        boolean flag=false;
	   try 
	   {
		 MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg,true);
	       
	        helper.setTo(to);

	        helper.setSubject(subject);

	        helper.setText(message,true);

	        javaMailSender.send(msg);
	        
	        return true;

         }
	   catch(Exception e)
	   {
		   return false;
	   }
	   
	
	
	
	}
	
	}
