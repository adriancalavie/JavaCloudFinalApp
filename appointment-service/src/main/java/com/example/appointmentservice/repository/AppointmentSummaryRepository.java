package com.example.appointmentservice.repository;

import com.example.appointmentservice.exception.AlreadyThereException;
import com.example.appointmentservice.exception.NotFoundException;
import com.example.appointmentservice.model.AppointmentSummary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AppointmentSummaryRepository {
	List<AppointmentSummary> getAll();
	
	void add(AppointmentSummary appointment) throws AlreadyThereException;
	
	void update(AppointmentSummary appointment) throws NotFoundException;
	
	void delete(AppointmentSummary id) throws NotFoundException;
	
	AppointmentSummary get(String id) throws NotFoundException;
	
	Optional<AppointmentSummary> findById(String id) throws NotFoundException;
}
