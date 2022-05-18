package com.lhs.restcontroller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.dao.AppoinmentRepo;
import com.lhs.entity.Appoinment;
import com.lhs.entity.PatientPreData;
import com.lhs.entity.RegistrationEntity;
import com.lhs.service.NurseService;

@RestController
@RequestMapping("/api")
public class NurseController {
	@Autowired
	NurseService nurseService;
	@Autowired
	AppoinmentRepo appoinmentRepo;
	
	private int count;
	 
	@PostMapping("/AddingPreData/{Id}")
	public ResponseEntity<String> addingPreData(@RequestBody   PatientPreData patientPreData,@PathVariable("Id") RegistrationEntity entity)
	{
		System.out.println(patientPreData.getWeight());    	
		patientPreData.setEntity(entity);
		//System.out.println("hiii");
		nurseService.preData(patientPreData);
		//System.out.println("hello");
		return new ResponseEntity<String>("preDataAddedByNurse",HttpStatus.OK);
	}
	
	
	
	@PostMapping("/currentDate")
	 public String  currentAppoinments(@RequestBody Appoinment appoinment)
	 {
		
		  LocalDateTime datetime1 = LocalDateTime.now();  
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		    String formatDateTime = datetime1.format(format);   
		    System.out.println(formatDateTime);    
		
		return formatDateTime ;
		
	 }
	

	//Getting current Date appoinments
	@GetMapping("/CurrentdateAppoinments")
	public ResponseEntity<?> currentDate() {
   
		 LocalDate datetime1 = LocalDate.now(); 
		 
	List<Appoinment> e= appoinmentRepo.findByDate(datetime1);
	
	e.stream().map(Appoinment::getApstatus).collect(Collectors.toList());
	
		List<Appoinment> dummy= new ArrayList<>();
        for(Appoinment appoinment2 : e) 
		    {
			  
				if( appoinment2.getApstatus()==true)
				{   
					dummy.add(appoinment2);
			
					
				}
		       
	        }
	
	return new ResponseEntity<List<Appoinment>>( dummy,HttpStatus.OK);   
			
	}
	
	
	
	@GetMapping("/upcomingappoinments")
	public ResponseEntity<?> upcomingAp(){
		
		
		
		
		
	}
	
	

	
	
		
	
	

}
