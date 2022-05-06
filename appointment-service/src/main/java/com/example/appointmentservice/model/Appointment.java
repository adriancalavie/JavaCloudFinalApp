package com.example.appointmentservice.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Appointment {
	String id;
	Car car;
	LocalDateTime startDate;
	LocalDateTime endDate;
	User user;
}
