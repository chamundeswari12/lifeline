package com.lhs.dao;

import java.util.Date;
import java.util.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lhs.entity.SlotBooking;

public interface SlotRepo extends CrudRepository<SlotBooking, Integer> {
	
	
	boolean existsByDayid(Date date);
	//SlotBooking existsBySlot1ORSlot2ORSlot3(SlotBooking slot);
}