package com.lhs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Supplements {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  String name;
	private String quantity;
	
	
	@OneToOne
	private RegistrationEntity entity;

	
	
	public Supplements()
	{
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getQuantity() {
		return quantity;
	}



	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public RegistrationEntity getEntity() {
		return entity;
	}



	public void setEntity(RegistrationEntity entity) {
		this.entity = entity;
	}



	public Supplements(int id, String name, String quantity, RegistrationEntity entity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.entity = entity;
	}



	@Override
	public String toString() {
		return "Supplements [id=" + id + ", name=" + name + ", quantity=" + quantity + ", entity=" + entity + "]";
	}
	
	
	
	
	
	
	

}
