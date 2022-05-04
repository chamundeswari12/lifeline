package com.lhs.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lhs.entity.SlotBooking;

public interface SlotRepo extends CrudRepository<SlotBooking, Integer> {
	
	
	boolean existsByDayid(Date dayid);

}
