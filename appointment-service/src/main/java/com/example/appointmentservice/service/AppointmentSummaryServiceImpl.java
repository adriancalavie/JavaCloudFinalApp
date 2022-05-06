package com.example.appointmentservice.service;

import com.example.appointmentservice.model.AppointmentSummary;
import com.example.appointmentservice.repository.AppointmentSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentSummaryServiceImpl implements AppointmentSummaryService {
	final AppointmentSummaryRepository appointmentSummaryRepository;
	
	@Autowired
	public AppointmentSummaryServiceImpl(AppointmentSummaryRepository appointmentSummaryRepository) {
		this.appointmentSummaryRepository = appointmentSummaryRepository;
	}
	
	
	@Override
	public List<AppointmentSummary> getAll() {
		return appointmentSummaryRepository.getAll();
	}
	
	@Override
	public void create(AppointmentSummary appointmentSummary) {
		appointmentSummaryRepository.add(appointmentSummary);
	}
	
	@Override
	public AppointmentSummary read(String id) {
		return appointmentSummaryRepository.get(id);
	}
	
	@Override
	public void update(AppointmentSummary appointment) {
		appointmentSummaryRepository.update(appointment);
	}
	
	@Override
	public void delete(AppointmentSummary appointmentSummary) {
		appointmentSummaryRepository.delete(appointmentSummary);
	}
}
