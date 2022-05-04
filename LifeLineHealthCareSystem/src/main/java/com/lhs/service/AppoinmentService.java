package com.lhs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhs.PlayLoad.AppoinmentDetails;
import com.lhs.dao.AppoinmentRepo;
import com.lhs.dao.DoctorRepo;
import com.lhs.dao.SlotRepo;
import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
import com.lhs.entity.Doctor;
import com.lhs.entity.SlotBooking;

@Service
public class AppoinmentService {


	@Autowired
	DoctorRepo doctorRepo;
	@Autowired
	AppoinmentRepo appoinmentRepo;
	@Autowired
	SlotRepo slotRepo;


	public Doctor doctors;
	private SlotBooking booking;

	public List<Doctor> bookingAppoinment(Doctor doc) {
      
		
		List<Doctor>  list=doctorRepo.findByDoctorNameAndSpecialistAndLocationAndAvailableTime
		 (doc.getDoctorName(), doc.getSpecialist(), doc.getLocation(), doc.getAvailableTime());
		return  list; 

	}





	public void slotBooking(Appoinment appoinment)
	{



		appoinment.setApstatus(AppoinmentStatus.booked);

		appoinmentRepo.save(appoinment);
		System.out.println(appoinmentRepo);





	}







}
