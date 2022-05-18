package com.lhs.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.Appoinment;
import com.lhs.entity.AppoinmentStatus;
@Repository
public interface AppoinmentRepo extends CrudRepository<Appoinment, Integer> {

	Appoinment  existsByApstatus(AppoinmentStatus appoinmentStatus);
	//boolean existsByApstatus(AppoinmentStatus apstatus);

    int  findByApstatus(int apstatus);
	
  public  List<Appoinment>  findByDate(LocalDate date);

	Appoinment findById(int id);
	
	

}
