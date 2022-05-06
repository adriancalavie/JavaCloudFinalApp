package com.example.appointmentservice.service;

import com.example.appointmentservice.model.AppointmentSummary;

import java.util.List;


public interface AppointmentSummaryService {
	List<AppointmentSummary> getAll();
	
	void create(AppointmentSummary appointmentSummary);
	
	AppointmentSummary read(String id);
	
	void update(AppointmentSummary appointmentSummary);
	
	void delete(AppointmentSummary appointmentSummary);
}
