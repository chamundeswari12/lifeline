package com.lhs.entity;

import java.util.Date;
import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity(name="Appoinment")
public class Appoinment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date dayid;
	private LocalTime slot1;
	private LocalTime slot2;
	private LocalTime slot3;
	 
	@Enumerated(EnumType.STRING)
	private AppoinmentStatus apstatus;
	
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	private Doctor doctor;
	
	
	

	

	public Date getDayid() {
		return dayid;
	}

	public void setDayid(Date dayid) {
		this.dayid = dayid;
	}

	public LocalTime getSlot1() {
		return slot1;
	}

	public void setSlot1(LocalTime slot1) {
		this.slot1 = slot1;
	}

	public LocalTime getSlot2() {
		return slot2;
	}

	public void setSlot2(LocalTime slot2) {
		this.slot2 = slot2;
	}

	public LocalTime getSlot3() {
		return slot3;
	}

	public void setSlot3(LocalTime slot3) {
		this.slot3 = slot3;
	}

	public int getId() {
		
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppoinmentStatus getApstatus() {
		return apstatus;
	}

	public void setApstatus(AppoinmentStatus apstatus) {
		this.apstatus = apstatus;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appoinment [id=" + id + ", apstatus=" + apstatus + ", doctor=" + doctor + "]";
	}
	

}
