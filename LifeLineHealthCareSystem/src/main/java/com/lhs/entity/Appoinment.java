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
	private LocalTime slot;
	 
	@Enumerated(EnumType.STRING)
	private AppoinmentStatus apstatus;
	
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	private Doctor doctor;
	
	
	

	


	

}
