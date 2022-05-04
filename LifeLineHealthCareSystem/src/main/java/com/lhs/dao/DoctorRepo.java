package com.lhs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.Doctor;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	List<Doctor> findBySpecialistAndLocation(String specialist, String location);
     List<Doctor> findByDoctorNameAndSpecialistAndLocationAndAvailableTime(String DoctorName,
    		 String specialist,String Location,Date availableTime);
	
	
	
	
}
