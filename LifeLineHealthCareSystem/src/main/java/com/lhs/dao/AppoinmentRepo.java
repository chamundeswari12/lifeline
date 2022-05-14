package com.lhs.dao;

import java.time.LocalTime;

import org.springframework.data.repository.CrudRepository;

import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
import com.lhs.entity.Doctor;

public interface AppoinmentRepo extends CrudRepository<Appoinment, Integer> {

	
	Doctor findByDayid(java.util.Date dayid);
	Appoinment  existsByApstatus(AppoinmentStatus appoinmentStatus);
//	Appoinment findByApstatus(AppoinmentStatus appoinmentStatus);
	Appoinment findBySlot(LocalTime slot);
	 
	

}
