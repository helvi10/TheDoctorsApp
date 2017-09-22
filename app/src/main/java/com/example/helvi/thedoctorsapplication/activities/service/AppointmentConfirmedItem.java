package com.example.helvi.thedoctorsapplication.activities.service;


import com.google.gson.annotations.SerializedName;

public class AppointmentConfirmedItem{

	@SerializedName("AppointmentNo")
	private int appointmentNo;

	public void setAppointmentNo(int appointmentNo){
		this.appointmentNo = appointmentNo;
	}

	public int getAppointmentNo(){
		return appointmentNo;
	}

	@Override
 	public String toString(){
		return 
			"AppointmentConfirmedItem{" + 
			"appointmentNo = '" + appointmentNo + '\'' + 
			"}";
		}
}