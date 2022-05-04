package com.lhs.restcontroller;

import java.security.Principal;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.PlayLoad.LoadEmail;
import com.lhs.PlayLoad.PasswordChange;
import com.lhs.customexception.GlobalExceptionHandler;
import com.lhs.dao.RegistrationRepo;
import com.lhs.dto.RegistrationDto;


import com.lhs.entity.RegistrationEntity;
import com.lhs.jwthandler.JwtRequest;
import com.lhs.jwthandler.JwtResponse;
import com.lhs.jwthandler.JwtUtil;
import com.lhs.security.ImplementationUserDetailsService;
import com.lhs.service.GetService;
import com.lhs.service.RegistrationService;

@RestController
//@RequestMapping("/api")
@CrossOrigin("")
public class RegistrationController {
	int otp;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	GetService serv;

	Logger logger = org.slf4j.LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	JwtUtil jwtUtility;
	 
	@Autowired
	ImplementationUserDetailsService detailsService;

	@Autowired
	RegistrationRepo registrationRepo;

	@Autowired
	RegistrationService service;

	@Autowired
	com.lhs.service.EmailService emailService;

	@GetMapping("/")
	public String home() {

		logger.info("checking html page ");
		return "Hii Dude";
	}

	@PostMapping("/login")
	public String loginPage() {
		logger.info("login method executed");
		return "login";
	}

	@RequestMapping("/logg")
	public String logout() {
		logger.info("logout called");
		return "logout";
	}

	@PostMapping("/register")
	public ResponseEntity<String> addRegistration(@RequestBody @Valid RegistrationDto register) {

		logger.info("executed add method in controller");
		if (register == null) {
			logger.error("registration object is null");
		}

		service.addAccount(register);
		logger.info("account saved in the database sucessfull");

		return ResponseEntity.ok("added account sucessfully " + register.getUsername());

	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = detailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtUtility.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(jwt));
	}


	@GetMapping("/get")
	public Iterable<RegistrationEntity> get() {

		Iterable<RegistrationEntity> ge = serv.getUsers();
		return ge;

	}
	@PutMapping("/updateduser")
	public String  updateuser(@RequestBody RegistrationDto  registrationDto,  Principal principal)
	{
	 String log=principal.getName();
	 service.updateuser(registrationDto,log);
	 return "update successfully";
	}}
	
//	@PostMapping("/sentotp")
//	public String  gettingOtp(@RequestBody LoadEmail email) throws MessagingException
//	{  
//		 //boolean eg=registrationRepo.findByEmail(email.getEmail());
//		
//	  //if(eg==true) {                                                                                                                                                                                                                                         
//	    Random random=new Random();
//	      otp=random.nextInt(99999);
//	     String subject="Otp from lhs";
//	     String message="otp "+otp;
//	     String to=email.getEmail();
//	     emailService.sendOtpMessage(to,subject,message);
//	   
//	     return "otp sended to your email";
////	}
////	   return "enter valid email";
//	}
	
	
	
	
	
//	@PostMapping("/validation")
//	public ResponseEntity<String> validatingOtp(@RequestBody LoadEmail motp,HttpSession session)
//	{  
//		session.setAttribute("sendedotp",otp);
//		//session.setAttribute("email",email);
//	    int myotp=(int)session.getAttribute("sendedotp");
//		String email=(String)session.getAttribute("email");
//		
//
//		if(myotp==motp.getOtp())
//	
////			UserDetails userDetails=detailsService.loadUserByUsername(email);
////			System.out.println(userDetails);
//			return new ResponseEntity<String>("verified ", HttpStatus.OK);
//	
//		else 
//			return new ResponseEntity<String>("Invalid ", HttpStatus.NOT_FOUND);
//	}}













