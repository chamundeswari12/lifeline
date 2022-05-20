package com.lhs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.dao.MonitoringDataRepo;
import com.lhs.entity.MonitoringData;


@RestController
public class NurseService {
	@Autowired
	MonitoringDataRepo monitoringDataRepo;
	
	public void preData(MonitoringData preData) {
		
		//System.out.println(preData.getWeight());
		
		MonitoringData y=monitoringDataRepo.save(preData);
		 System.out.println(y);
		
	}
	

}
