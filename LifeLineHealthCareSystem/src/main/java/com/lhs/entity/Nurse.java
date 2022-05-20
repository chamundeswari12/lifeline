package com.lhs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nurseName;
	
	
	
	
	
	
	
	public Nurse() {
		
	}







	public Nurse(int id, String nurseName) {
		super();
		this.id = id;
		this.nurseName = nurseName;
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getNurseName() {
		return nurseName;
	}







	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}







	@Override
	public String toString() {
		return "Nurse [id=" + id + ", nurseName=" + nurseName + "]";
	}
	
	

}
