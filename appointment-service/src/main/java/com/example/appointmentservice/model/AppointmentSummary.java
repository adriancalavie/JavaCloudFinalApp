package com.example.appointmentservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentSummary {
	String id;
	Appointment appointment;
	User mechanic;
	String comment;
	Double totalCost;
}
