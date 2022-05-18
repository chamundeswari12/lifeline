package com.lhs.restcontroller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.PlayLoad.SMSStoringOtp;
import com.lhs.PlayLoad.TempOtp;
import com.lhs.entity.SMSPojo;
import com.lhs.service.SmsService;

@RestController
public class SMSController {
	
	@Autowired
    SmsService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

   private final String  TOPIC_DESTINATION = "/lesson/sms";
  
    @PostMapping( "/sendingotp")
    public ResponseEntity<String> smsSubmit(@RequestBody SMSPojo sms) {
        try{
        	
               service.send(sms);
           
        }
        catch(Exception e){

        	 return new ResponseEntity<String>("check u r mobileno",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: "+sms.getMobileno());
        return new ResponseEntity<String>("otp sended successfully",HttpStatus.OK);
    }

//    @PostMapping("/smscallback")
//          
//    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
//       //service.receive(map);
//       webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Twilio has made a callback request! Here are the contents: "+map.toString());
//    }
//
   private String getTimeStamp() {
      return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
   }
    @PostMapping("/verificationotp")
    public ResponseEntity<String> verify(@RequestBody TempOtp tempOtp)
    {
    	 int otp=SMSStoringOtp.getOtp();
    	 System.out.println(otp);
    	if(tempOtp.getOtp()==otp)
    	{
    		return new ResponseEntity<String>("valid",HttpStatus.OK);
    	}
 
    	return new ResponseEntity<String>("invalid",HttpStatus.BAD_REQUEST);
    }
    
    
    

}
