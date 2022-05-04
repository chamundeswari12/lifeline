package com.lhs.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.PlayLoad.AppoinmentDetails;
import com.lhs.dao.AppoinmentRepo;
import com.lhs.dao.SlotRepo;
import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
import com.lhs.entity.Doctor;
import com.lhs.entity.SlotBooking;
import com.lhs.service.AppoinmentService;
import com.lhs.service.DoctorService;

@RestController
public class AppoinmentController {
	
	@Autowired
	AppoinmentRepo appoinmentRepo;
	@Autowired
	SlotRepo slotRepo;
	@Autowired
	AppoinmentService appoinmentService;
	@Autowired
	DoctorService doctorService;
	private Doctor doctor;


	
	//adding slots to doctors based on available time
	@PostMapping("/add")
	public ResponseEntity<String> addingcontroller(@RequestBody SlotBooking doc)
	{
		doctorService.slotadding(doc);

		return ResponseEntity.ok(" slot added sucessfully "  );
		

	}
	
	
	//Booking appoinment
	@PostMapping("/BookingAppoinment")
	public List<Doctor> bookingappoinment(@RequestBody Doctor doctor)
	{
		
		 List<Doctor> doc=appoinmentService.bookingAppoinment(doctor);
		 System.out.println("appoinment was booked successfully");
		 System.out.println(doc);
		 return doc;
		 
		
	}
	

	
	
	//Checking doctor availability for that particular day
	@PostMapping("/AvailableDay")
	public String checkingavailableDay(@RequestBody SlotBooking doc)
	{
		if(slotRepo.existsByDayid(doc.getDayid()))
		{
			
			System.out.println("gggggggggggg");
			doctorService.slotadding(doc);
		return "doctor is avilable";
		}
		else {
		 return "doctor is not available";}
		
	}
	////////////////
	
    @PostMapping("/slotbooked/{id}")
	public ResponseEntity<String> slotbooking(@RequestBody Appoinment appoinment, @PathVariable ("id") Doctor doctor) {
    	
    	if(slotRepo.existsByDayid(appoinment.getDayid()))
		{
    	doctor.setId(doctor.getId());
    	
    	appoinment.setDoctor(doctor);
    	 
    	appoinmentService.slotBooking(appoinment);
    	
    	return new ResponseEntity<String>("slotBooked successfully with "+doctor.getDoctorName(), HttpStatus.OK);
		}
    	else
    		return new ResponseEntity<String>("no doctor available in this date", HttpStatus.OK);
    }
	
    
    
    
    
    
       
    @PostMapping("/forBooking")
    public ResponseEntity<String> slothold(@RequestBody Appoinment appoinment){
    	 
    	boolean y=appoinmentRepo.existsByApstatus(appoinment.getApstatus());
    	System.out.println(y);
    	if(y==false)
    	
    	{
    		
    		doctor.setId(doctor.getId());
        	
        	appoinment.setDoctor(doctor);
        	 
        	appoinmentService.slotBooking(appoinment);
        	
        	return new ResponseEntity<String>("slotBooked successfully with "+ doctor.getDoctorName(), HttpStatus.OK);
    		
    	}
    	else
    		return new ResponseEntity<String>("slotBooked already booked "+ doctor.getDoctorName(), HttpStatus.OK);
    	
    	
    }
    
    
    
    
    
    
    
    
    
	
	
	
	
}
