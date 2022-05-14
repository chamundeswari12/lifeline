package com.lhs.restcontroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.PlayLoad.AppoinmentDetails;
import com.lhs.dao.AppoinmentRepo;
import com.lhs.dao.DoctorRepo;
import com.lhs.dao.SlotRepo;
import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
import com.lhs.entity.AppointmentPayload;
import com.lhs.entity.Doctor;

import com.lhs.entity.Slots;
import com.lhs.service.AppoinmentService;
import com.lhs.service.DoctorService;

@RestController
public class AppoinmentController {
	
	
	@Autowired
	DoctorRepo doctorRepo;

 @PostMapping("/addingdoc")
 public ResponseEntity<String> addingdoctor(@RequestBody Doctor doctor)
 {
	 
	 doctorRepo.save(doctor);
	 return new ResponseEntity<String>("doctor added successfully",HttpStatus.ACCEPTED);
 }
	
	
@PostMapping("/AddingSlots")
public ResponseEntity<String> addingslots(@RequestBody Slots slots) {

	
	return new ResponseEntity<String>("doctor added successfully",HttpStatus.ACCEPTED);
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//adding slots to doctors based on available time
//	@PostMapping("/add")
//	public ResponseEntity<String> addingcontroller(@RequestBody Slots doc)
//	{
//		doctorService.slotadding(doc);
//
//		return ResponseEntity.ok(" slot added sucessfully "  );
//		
//
//	}
//	
//	
//	//Booking appoinment
//	@PostMapping("/BookingAppoinment")
//	public List<Doctor> bookingappoinment(@RequestBody Doctor doctor)
//	{
//		
//		 List<Doctor> doc=appoinmentService.bookingAppoinment(doctor);
//		 System.out.println("appoinment was booked successfully");
//		 System.out.println(doc);
//		 return doc;
//		 
//		
//	}
//	
//
//	
//	
//	//Checking doctor availability for that particular day
//	@PostMapping("/AvailableDay")
//	public String checkingavailableDay(@RequestBody SlotBooking doc)
//	{
//		if(slotRepo.existsByDayid(doc.getDayid()))
//		{
//			
//			System.out.println("gggggggggggg");
//			doctorService.slotadding(doc);
//		return "doctor is avilable";
//		}
//		else {
//		 return "doctor is not available";}
//		
//	}
//	////////////////
//	
//    @PostMapping("/slotbooked/{id}")
//	public ResponseEntity<String> slotbooking(@RequestBody Appoinment appoinment, @PathVariable ("id") Doctor doctor) {
//    	
//    	if(slotRepo.existsByDayid(appoinment.getDayid()))
//		{
//    	doctor.setId(doctor.getId());
//    	
//    	appoinment.setDoctor(doctor);
//    	 
//    	appoinmentService.slotBooking(appoinment);
//    	
//    	return new ResponseEntity<String>("slotBooked successfully with "+doctor.getDoctorName(), HttpStatus.OK);
//		}
//    	else
//    		return new ResponseEntity<String>("no doctor available in this date", HttpStatus.OK);
//    }
//	
//    
//    
//    
//    
//    
////       
////    @PostMapping("/forBooking")
////    public ResponseEntity<String> slothold(@RequestBody Appoinment appoinment,@PathVariable Doctor doctor){
////    	 
////    	Appoinment y=appoinmentRepo.existsByApstatus(appoinment.getApstatus());
////    	System.out.println(y);  
////    	if(y==false)
////    	
////    	{    
////    		
////    		doctor.setId(doctor.getId());
////    		
////    		
////    		
////        	
////        	appoinment.setDoctor(doctor);
////        	 
////        	appoinmentService.slotBooking(appoinment);
////        	
////        	return new ResponseEntity<String>("slotBooked successfully with "+ doctor.getDoctorName(), HttpStatus.OK);
////    		
////    	}
////    	else
////    		return new ResponseEntity<String>("slotBooked already booked "+ doctor.getDoctorName(), HttpStatus.OK);
////    	
////    	
////    }
////    
//    
//    
//    
//    @PostMapping("/geetingstatus/{id}")
//    public ResponseEntity<Appoinment> slotstatus(@RequestBody Appoinment appoinment, @PathVariable ("id") Doctor doctor){
//    	
//    	
//    	//System.out.println(appoinmentRepo.findById(1));
//    	//	System.out.println(appoinment.getApstatus());
//    //	System.out.println(doctor);
//    	Appoinment y=appoinmentRepo.findBySlot1(appoinment.getSlot1()); 
//         System.out.println(y);
//         return new ResponseEntity<Appoinment>(y, HttpStatus.ACCEPTED);
//    }
//    
//    
//    
//    
    
    
    
    
	
	
	
	
}
