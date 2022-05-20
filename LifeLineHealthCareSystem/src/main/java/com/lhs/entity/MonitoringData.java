package com.lhs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MonitoringData")
public class MonitoringData{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bloodPressure;
	private String temperature;
	private String weight;
	private long height;
	private String heartRate;
	@OneToOne
	private Nurse nurse;
	@OneToOne
	@JoinColumn(name="patient_id")
    private RegistrationEntity entity;
	
	
	
	
	
	public MonitoringData()
	{
	
	}

	
	public MonitoringData(int id, String bloodPressure, String temperature, String weight, long height, String heartRate,
			Nurse nurse, RegistrationEntity entity) {
		super();
		this.id = id;
		this.bloodPressure = bloodPressure;
		this.temperature = temperature;
		this.weight = weight;
		this.height = height;
		this.heartRate = heartRate;
		this.nurse = nurse;
		this.entity = entity;
	}


	@Override
	public String toString() {
		return "PatientPreData [id=" + id + ", bloodPressure=" + bloodPressure + ", temperature=" + temperature
				+ ", weight=" + weight + ", height=" + height + ", heartRate=" + heartRate + ", nurse=" + nurse
				+ ", entity=" + entity + "]";
	}


	public Nurse getNurse() {
		return nurse;
	}


	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}


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

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public RegistrationEntity getEntity() {
		return entity;
	}

	public void setEntity(RegistrationEntity entity) {
		this.entity = entity;
	}
	
   
    
    
    
    
    
    


    
    
	

}
