package com.example.helvi.thedoctorsapplication.activities.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AppointmentConfirmation{

	@SerializedName("Appointment Confirmed")
	private List<AppointmentConfirmedItem> appointmentConfirmed;

	public void setAppointmentConfirmed(List<AppointmentConfirmedItem> appointmentConfirmed){
		this.appointmentConfirmed = appointmentConfirmed;
	}

	public List<AppointmentConfirmedItem> getAppointmentConfirmed(){
		return appointmentConfirmed;
	}

	@Override
 	public String toString(){
		return 
			"AppointmentConfirmation{" + 
			"appointment Confirmed = '" + appointmentConfirmed + '\'' + 
			"}";
		}
}