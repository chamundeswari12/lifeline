package com.lhs.entity;

import java.sql.Date;
import java.time.LocalDate;
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
	
	private LocalDate date;
    private LocalTime slottime; 
	public boolean apstatus;
	@OneToOne
	private Doctor doctor;
	@OneToOne(cascade=CascadeType.ALL)
	private RegistrationEntity registrationEntity;
	
	public Appoinment() {
	}
	
	
	
	
	
	
	public Appoinment(int id, LocalDate date, LocalTime slottime,boolean apstatus, Doctor doctor,
			RegistrationEntity registrationEntity) {
		super();
		this.id = id;
		this.date = date;
		this.slottime = slottime;
		this.apstatus = apstatus;
		this.doctor = doctor;
		this.registrationEntity = registrationEntity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalTime getSlottime() {
		return slottime;
	}
	public void setSlottime(LocalTime slottime) {
		this.slottime = slottime;
	}
	public boolean getApstatus() {
		return apstatus;
	}
	public boolean setApstatus(boolean apstatus) {
		return this.apstatus = apstatus;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public RegistrationEntity getRegistrationEntity() {
		return registrationEntity;
	}
	public void setRegistrationEntity(RegistrationEntity registrationEntity) {
		this.registrationEntity = registrationEntity;
	}






	public LocalDate getDate() {
		return date;
	}






	public void setDate(LocalDate date) {
		this.date = date;
	}






	@Override
	public String toString() {
		return "Appoinment [id=" + id + ", date=" + date + ", slottime=" + slottime + ", apstatus=" + apstatus
				+ ", doctor=" + doctor + ", registrationEntity=" + registrationEntity + "]";
	}
	
	
	
	
	
	

	

}
