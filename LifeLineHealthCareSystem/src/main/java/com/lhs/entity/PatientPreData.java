package com.lhs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patientpre")
public class PatientPreData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bloodPressure;
	private long temperature;
	private int weight;
	private long height;
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public long getTemperature() {
		return temperature;
	}

	public void setTemperature(long temperature) {
		this.temperature = temperature;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public RegistrationEntity getEntity() {
		return entity;
	}

	public void setEntity(RegistrationEntity entity) {
		this.entity = entity;
	}

	@OneToOne 
    private RegistrationEntity entity;

	@Override
	public String toString() {
		return "PatientPreData [id=" + id + ", bloodPressure=" + bloodPressure + ", temperature=" + temperature
				+ ", weight=" + weight + ", height=" + height + ", entity=" + entity + "]";
	}

	public PatientPreData(int id, String bloodPressure, long temperature, int weight, long height,
			RegistrationEntity entity) {
		super();
		this.id = id;
		this.bloodPressure = bloodPressure;
		this.temperature = temperature;
		this.weight = weight;
		this.height = height;
		this.entity = entity;
	}

	public PatientPreData() {
		super();
	}
    
    
    
    
    
    


    
    
	

}
