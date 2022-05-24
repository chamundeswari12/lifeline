package com.lhs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.dao.MonitoringDataRepo;
import com.lhs.dao.SupplementsRepo;
import com.lhs.entity.MonitoringData;
import com.lhs.restcontroller.NurseInterface;


@RestController
public class NurseService implements NurseInterface {
	@Autowired
	MonitoringDataRepo monitoringDataRepo;
	@Autowired
	SupplementsRepo supplementsRepo;
	
	public void preData(MonitoringData preData) {
		
		
		MonitoringData y=monitoringDataRepo.save(preData);

		
	}

	
	public void update(MonitoringData monitoringData)
	{
		monitoringDataRepo.save(monitoringData);
	}


	@Override
	public MonitoringData getMonitoringDataById(int id) {
		
		Optional<MonitoringData> optional = monitoringDataRepo.findById(id);
		MonitoringData data=null;
		if (optional.isPresent()) {
			data = optional.get();
		} else {
			throw new RuntimeException(" patient not found for id :: " + id);
		}
		monitoringDataRepo.save(data);
		return data;
	}
	
	

}
