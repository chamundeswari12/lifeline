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

	
	public MonitoringData update(MonitoringData monitoringData,int id)
	
	{    
		MonitoringData f= monitoringDataRepo.findById(id);
		System.out.println(f);
		f.setBloodPressure(monitoringData.getBloodPressure());
		f.setHeartRate(monitoringData.getHeartRate());
		f.setHeight(monitoringData.getHeight());
		f.setWeight(monitoringData.getWeight());
		f.setTemperature(monitoringData.getTemperature());
		 MonitoringData updatedUser=monitoringDataRepo.save(f);
		 return updatedUser;
	}


//	@Override
//	public MonitoringData getMonitoringDataById(MonitoringData data,int id) {
//		
//		Optional<MonitoringData> optional = monitoringDataRepo.findById(id);
//		optional.se
//		return monitoringDataRepo.save(data);
		
//		MonitoringData data=null;
//		if (optional.isPresent()) {
//			data = optional.get();
//		} else {
//			throw new RuntimeException(" patient not found for id :: " + id);
//		}
//		monitoringDataRepo.save(data);
//		return data;
//	}
	
	

}
