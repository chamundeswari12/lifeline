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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.dao.AppoinmentRepo;
import com.lhs.dao.MonitoringDataRepo;
import com.lhs.dao.NurseRepo;
import com.lhs.dao.SupplementsRepo;
import com.lhs.entity.Appoinment;
import com.lhs.entity.Nurse;
import com.lhs.entity.MonitoringData;
import com.lhs.entity.RegistrationEntity;
import com.lhs.entity.Supplements;
import com.lhs.service.NurseService;

@RestController
@RequestMapping("/api")
public class NurseController {
	@Autowired
	NurseService nurseService;
	@Autowired
	AppoinmentRepo appoinmentRepo;
	
    @Autowired
    NurseRepo nurseRepo;
    @Autowired
    MonitoringDataRepo monitoringDataRepo;
	@Autowired
	SupplementsRepo supplementsRepo;
	
		
	@PostMapping("/nursedata")
	public  ResponseEntity<String> AddingNurse(@RequestBody Nurse nurse)
	{
		nurseRepo.save(nurse);
		return new ResponseEntity<String>("nurse added successfully"+nurse.getNurseName(),HttpStatus.OK);
		
	}
	
	@PostMapping("/supplements/{patient_id}")
	public  ResponseEntity<String> AddingSupplements(@RequestBody Supplements supplements,@PathVariable("patient_id") RegistrationEntity entity)
	{
		supplements.setEntity(entity);
		supplementsRepo.save(supplements);
		
		return new ResponseEntity<String>("Supplements added successfully",HttpStatus.OK);
		
	}
	
	@PostMapping("/AddingPreData/{nurseid}/{patient_Id}")
	public ResponseEntity<String> addingPreData(@RequestBody MonitoringData patientPreData,@PathVariable("patient_Id") RegistrationEntity entity,@PathVariable("nurseid") Nurse nurse)
	{
		patientPreData.setTemperature(patientPreData.getTemperature()+" °F");
		patientPreData.setHeartRate(patientPreData.getHeartRate()+" BPM");
		patientPreData.setWeight(patientPreData.getWeight()+" kgs");
		patientPreData.setEntity(entity);
		patientPreData.setNurse(nurse);
		nurseService.preData(patientPreData);
				return new ResponseEntity<String>("preDataAddedByNurse",HttpStatus.OK);
	}
	
	
	
	@GetMapping("/AllPatientMonitoringData")
	public  List<MonitoringData> allMonitoringData(){
		
		 
		List<MonitoringData> g=monitoringDataRepo.findAll();
		
		return g;
		
	}
	

	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateMonitoringData(@RequestBody MonitoringData data,@PathVariable("id") int id)
	{
		data.setTemperature(data.getTemperature()+" °F");
		data.setHeartRate(data.getHeartRate()+" BPM");
		data.setWeight(data.getWeight()+" kgs");
		
		nurseService.update(data, id);
		return new ResponseEntity<String>("update successfully",HttpStatus.OK);
		
	}
	
	
	
	
//	@PostMapping("/currentDate")    
//	 public String  currentAppoinments(@RequestBody Appoinment appoinment)
//	 {
//		
//		  LocalDateTime datetime1 = LocalDateTime.now();  
//		    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
//		    String formatDateTime = datetime1.format(format);   
//		    System.out.println(formatDateTime);    
//		
//		return formatDateTime ;
//		
//	 }
//	

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
		 LocalDate datetime1 = LocalDate.now();
		 
		 List<Appoinment> f= appoinmentRepo.findAllDateAfter(datetime1);
		
		 f.stream().map(Appoinment::getApstatus).collect(Collectors.toList());
			
			List<Appoinment> dummy= new ArrayList<>();
	        for(Appoinment appoinment2 : f) 
			    {
				  
					if( appoinment2.getApstatus()==true)
					{   
						dummy.add(appoinment2);
				
						
					}
			       
		        }
		System.out.println(dummy);
		return new ResponseEntity<List<Appoinment>>( dummy,HttpStatus.OK);   
				
		}
		
	
	
	

	
	
		
	
	

}
