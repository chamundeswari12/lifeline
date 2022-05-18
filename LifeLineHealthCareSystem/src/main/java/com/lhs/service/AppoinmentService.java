package com.lhs.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhs.PlayLoad.AppoinmentDetails;
import com.lhs.dao.AppoinmentRepo;
import com.lhs.dao.DoctorRepo;

import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
import com.lhs.entity.Doctor;


@Service
public class AppoinmentService {


	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	AppoinmentRepo appoinmentRepo;



	public Doctor doctors;
	

	public List<Doctor> bookingAppoinment(Doctor doc) {
      
		
		List<Doctor>  list=doctorRepo.findByDoctorNameAndSpecialistAndLocationAndAvailableTime
		 (doc.getDoctorName(), doc.getSpecialist(), doc.getLocation(), doc.getAvailableTime());
		return  list; 

	}





	public void slotBooking(Appoinment appoinment)
	{


        //  boolean apstatus =true;
		 appoinment.setApstatus(true);

		appoinmentRepo.save(appoinment);
		System.out.println(appoinmentRepo.save(appoinment));





	}







}
