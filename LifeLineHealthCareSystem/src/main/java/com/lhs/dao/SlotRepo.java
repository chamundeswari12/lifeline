package com.lhs.dao;


import java.util.Calendar;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


import com.lhs.entity.Slots;

public interface SlotRepo extends CrudRepository<Slots, Integer> {
	
	
	boolean existsByDayid(Date date);
	//SlotBooking existsBySlot1ORSlot2ORSlot3(SlotBooking slot);
}