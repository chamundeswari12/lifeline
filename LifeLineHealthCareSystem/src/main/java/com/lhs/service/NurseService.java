package com.lhs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.dao.PatientPreDataRepo;
import com.lhs.entity.PatientPreData;
@RestController
public class NurseService {
	@Autowired
	PatientPreDataRepo patientPreDataRepo;
	
	public void preData(PatientPreData preData) {
		
		System.out.println(preData.getWeight());
		
		 PatientPreData y=patientPreDataRepo.save(preData);
		 System.out.println(y);
		
	}
	

}
