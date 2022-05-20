package com.lhs.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lhs.entity.Appoinment;

@Repository
public interface AppoinmentRepo extends CrudRepository<Appoinment, Integer> {

	

    //int  findByApstatus(int apstatus);
	
    public  List<Appoinment>  findByDate(LocalDate date);

	@Query("select a from Appoinment a where a.date > :LocalDate")
	List<Appoinment> findAllDateAfter(
		      @Param("LocalDate") LocalDate datetime1);

}
