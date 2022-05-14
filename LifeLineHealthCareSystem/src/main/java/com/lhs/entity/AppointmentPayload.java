 	package com.lhs.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AppointmentPayload {
	@Enumerated(EnumType.STRING)
	private AppoinmentStatus apstatus;
	
	public AppoinmentStatus getApstatus() {
		return apstatus;
	}
	public void setApstatus(AppoinmentStatus apstatus) {
		this.apstatus = apstatus;
	}
	private Date dayid;
    private LocalTime slot1;
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
	public AppointmentPayload() {
		super();
	}
	@Override
	public String toString() {
		return "AppointmentPayload [apstatus=" + apstatus + ", dayid=" + dayid + ", slot1=" + slot1 + "]";
	}
	

}
