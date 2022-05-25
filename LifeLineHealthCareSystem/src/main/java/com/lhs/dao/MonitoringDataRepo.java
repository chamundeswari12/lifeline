package com.lhs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lhs.entity.MonitoringData;

@Repository
public interface MonitoringDataRepo extends JpaRepository<MonitoringData, Integer> {
	@Modifying
	@Query("update MonitoringData m set m.bloodPressure=?1,m.temperature=?4,m.weight=?3,m.height=?5,m.heartRate=?2 where m.id=?6")
	void setMonitoringDataById(String bloodPressure, String heartRate, String weight, String temperature, long height,
			int id);
	
	 MonitoringData findById(int id);
	

}
