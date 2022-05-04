package com.lhs.restcontroller;

import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.PlayLoad.LoadEmail;
import com.lhs.dao.RegistrationRepo;
import com.lhs.entity.RegistrationEntity;
import com.lhs.service.EmailService;


@RestController
public class ForgotPasswordController {
	
	@Autowired
	EmailService emailService;
	@Autowired
	RegistrationRepo registrationRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
     int otp;

	@PostMapping("/sentotp")
	public String  gettingOtp(@RequestBody LoadEmail email,HttpSession session) throws MessagingException
	{  				

//        RegistrationEntity user= registrationRepo.findByEmail(email.getEmail());
//        if(email.getEmail()==user.getEmail())
//        {
	      Random random=new Random();
	      otp=random.nextInt(99999);
	     String subject="Otp from lhs";
	     String message="otp "+otp;
	     String to=email.getEmail();
	     boolean flag= emailService.sendOtpMessage(to,subject,message);
	     if(flag)
	     {
	      session.setAttribute("sendedotp",otp);
	      System.out.println(session.getAttribute("sendedotp"));
	      session.setAttribute("sendedemail",email.getEmail());
	      System.out.println(session.getAttribute("sendedemail"));
	     
	      return "otp sended to your email";
	     }
        
	     else
	     {
	    	 return "enter invalid address";
	     }
	  
	}
	
	
	
	
	@PostMapping("/validation")
	public ResponseEntity<String> validatingOtp(@RequestBody LoadEmail motp,HttpSession session)
	{  
	    int myotp=(int)session.getAttribute("sendedotp");
	    System.out.println(myotp);
		String email=(String)session.getAttribute("sendedemail");
		System.out.println(email);
		

		System.out.println(motp);
		if(myotp==motp.getOtp())
		{
		             RegistrationEntity user= registrationRepo.findByEmail(email);
		            		 if(user==null)
		            		 {
		            			 return  new ResponseEntity<String>("no data found with this email", HttpStatus.BAD_REQUEST	);
		            		 }
		
					return new ResponseEntity<String>("verified ", HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String>("Invalid ", HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/changingnewpassword")
	public ResponseEntity<String> changingPassword(@RequestBody LoadEmail newpassword,HttpSession session)
	{
		 String email=(String)session.getAttribute("sendedemail");
		 RegistrationEntity user= registrationRepo.findByEmail(email);
		 user.setPassword(bCryptPasswordEncoder.encode(newpassword.getNewpassword()));
		 registrationRepo.save(user);
		 return new ResponseEntity<String>("changed successfully",HttpStatus.OK);
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
//		@GetMapping("/gettingEmail")
//		public RegistrationEntity currentmail(@RequestBody LoadEmail email)
//		{
//		        
//				RegistrationEntity eg=registrationRepo.findByEmail(email.getEmail());
//			     System.out.println(eg.getEmail());
//				return eg;	
//         }
//		@GetMapping("/gettingEmailfrom")
//		public RegistrationEntity currentuser(@RequestBody LoadEmail email)
//		{
//		        
//	    Authentication auth=SecurityContextHolder.getContext().getAuthentication();
//	    return (RegistrationEntity) auth.getDetails();
//	    
//         }
//        @PostMapping("/loadingEmail")
//        public String loadingemail(@RequestBody LoadEmail email)
//        {
//        	RegistrationEntity eg=registrationRepo.findByEmail(email.getEmail());
//        	if(email.getEmail()==(eg.getEmail()))
//        	{
//        		return "yes";
//        	}
//        	return "no";
//        	
//        	
//        }








}
	
	


