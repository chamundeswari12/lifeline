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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Slots{

	private int id;
	private Date date;
	private LocalTime Time;
	@Enumerated(EnumType.STRING)
	private AppoinmentStatus apstatus;
	@OneToOne
	private Doctor doctor;
	
	public Slots() {}
	
	
	public Slots(int id, Date date, LocalTime time, AppoinmentStatus apstatus, Doctor doctor) {
		super();
		this.id = id;
		this.date = date;
		Time = time;
		this.apstatus = apstatus;
		this.doctor = doctor;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return Time;
	}
	public void setTime(LocalTime time) {
		Time = time;
	}
	public AppoinmentStatus getApstatus() {
		return apstatus;
	}
	public void setApstatus(AppoinmentStatus apstatus) {
		this.apstatus = apstatus;
	}
	
	
	

	
}








	
	
	
	
	
	
	
	


