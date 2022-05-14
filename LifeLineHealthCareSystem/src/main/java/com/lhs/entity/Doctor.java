package com.lhs.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

@Entity
public class Doctor {
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int id;
	   private String doctorName;
	   private String specialist;
	   private Date availableTime;
       private String feedback;
       private int rating;
       private String location;
       private int doctorfee;
       
       @Enumerated(EnumType.STRING)
       private DoctorAvailablity status;
       
	   @OneToMany
	   private List<Slot> slot;

	public List<Slot> getSlot() {
		return slot;
	}



	public void setSlot(List<Slot> slot) {
		this.slot = slot;
	}



	public Doctor() {
       
       }
       


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorName=" + doctorName + ", specialist=" + specialist + ", availableTime="
				+ availableTime + ", feedback=" + feedback + ", rating=" + rating + ", location=" + location
				+ ", doctorfee=" + doctorfee + "]";
	}



	public Doctor(String doctorName, String specialist, Date availableTime, String feedback, int rating,
			String location, int doctorfee) {
		super();
		this.doctorName = doctorName;
		this.specialist = specialist;
		this.availableTime = availableTime;
		this.feedback = feedback;
		this.rating = rating;
		this.location = location;
		this.doctorfee = doctorfee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public Date getAvailableTime() {
		return availableTime;
	}







	public void setAvailableTime(Date availableTime) {
		this.availableTime = availableTime;
	}







	public DoctorAvailablity getStatus() {
		return status;
	}







	public void setStatus(DoctorAvailablity status) {
		this.status = status;
	}







	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDoctorfee() {
		return doctorfee;
	}
	public void setDoctorfee(int doctorfee) {
		this.doctorfee = doctorfee;
	}
       
       
       
       
   


     

	
	
	

	
	

}
