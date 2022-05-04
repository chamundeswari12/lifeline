package com.lhs.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.lhs.PlayLoad.SMSStoringOtp;
import com.lhs.entity.SMSPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {
     private final String ACCOUNT_SID ="ACbf240fb7bdda48847d1eca61055bb11b";

    private final String AUTH_TOKEN = "61be876b9da6ba57a94ddfbe40df4a14";

    private final String FROM_NUMBER = "+18304901363";

    public void send(SMSPojo sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    	
        int min = 100000;  
         int max = 999999; 
        int number=(int)(Math.random()*(max-min+1)+min);
        SMSStoringOtp.setOtp(number);
      
        
        String msg ="Your OTP - "+number+ " please verify this OTP with the lhs.com";
       
        
        Message message = Message.creator(new PhoneNumber(sms.getMobileno()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
       
      /*  Date myDate=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf. parse(myDate.toString()); 
        long millis = date. getTime(); 
        System.out.println(millis);
       OTPpojo.setOtp(number);
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
*/
    }

    public void receive(MultiValueMap<String, String> smscallback) {
   
    }

}