package com.lhs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lhs.entity.MonitoringData;

@Repository
public interface MonitoringDataRepo extends JpaRepository<MonitoringData, Integer> {

}
