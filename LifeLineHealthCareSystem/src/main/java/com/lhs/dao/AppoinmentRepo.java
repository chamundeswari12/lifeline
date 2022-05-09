package com.lhs.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
import com.lhs.entity.Doctor;

public interface AppoinmentRepo extends CrudRepository<Appoinment, Integer> {
//	@Query("select * from Appoinment a where a.apstatus='Booked' ")
//	Appoinment getApstaus(Appoinment appoinment);

	
	Doctor findByDayid(Date dayid);
	Appoinment  existsByApstatus(AppoinmentStatus appoinmentStatus);
	//boolean existsByApstatus(AppoinmentStatus apstatus);

	Appoinment findByApstatus(AppoinmentStatus apstatus);
	
	

}
