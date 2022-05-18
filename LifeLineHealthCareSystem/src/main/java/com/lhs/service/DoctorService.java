package com.lhs.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhs.dao.AppoinmentRepo;
import com.lhs.dao.DoctorRepo;

import com.lhs.entity.Appoinment;
import com.lhs.entity.Doctor;
import com.lhs.entity.RegistrationEntity;

@Service
public class DoctorService {
	

			
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
    AppoinmentRepo  appoinmentRepo;
	
	RegistrationEntity reg;
	 Doctor doctors;

		public Doctor addingDoctor(Doctor doctor)
		{
			this.doctors= doctorRepo.save(doctor);
			
			return  this.doctors;
		}
	
	public void slotadding(Appoinment appoinment)
	{

		//Doctor doc=new Doctor();
		
		 appoinment.setDoctor(this.doctors);
		// appoinment.setRegistrationEntity(this.reg);

		 appoinmentRepo.save(appoinment);	   


	}
	
	
	
	
	public void slots(Appoinment appoinment)
	{
		appoinmentRepo.save(appoinment);
	}
	
	
	 public List<Doctor> findingall(Doctor doc)
	 {
		 return doctorRepo.findBySpecialistAndLocation(doc.getSpecialist(), doc.getLocation()); 
	 }
	 
	

		
	

}
