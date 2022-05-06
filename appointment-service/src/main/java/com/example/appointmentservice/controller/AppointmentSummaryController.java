package com.example.appointmentservice.controller;

import com.example.appointmentservice.exception.AlreadyThereException;
import com.example.appointmentservice.exception.NotFoundException;
import com.example.appointmentservice.model.AppointmentSummary;
import com.example.appointmentservice.service.AppointmentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentSummaryController {
	final AppointmentSummaryService appointmentSummaryService;
	
	@Autowired
	public AppointmentSummaryController(AppointmentSummaryService appointmentSummaryService) {
		this.appointmentSummaryService = appointmentSummaryService;
	}
	
	@GetMapping
	ResponseEntity<List<AppointmentSummary>> getAppointments() {
		return ResponseEntity.ok(appointmentSummaryService.getAll());
	}
	
	@GetMapping("{id}")
	ResponseEntity<?> getAppointmentSummary(@PathVariable String id) {
		try {
			return ResponseEntity.ok(appointmentSummaryService.read(id));
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	ResponseEntity<?> postAppointmentSummary(@RequestBody AppointmentSummary appointmentSummary) {
		try {
			appointmentSummaryService.create(appointmentSummary);
			return ResponseEntity.ok("Appointment with " + appointmentSummary.getId() + " has been created. ");
		} catch (AlreadyThereException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@PutMapping
	ResponseEntity<?> putAppointmentSummary(@RequestBody AppointmentSummary appointmentSummary) {
		try {
			appointmentSummaryService.update(appointmentSummary);
			return ResponseEntity.ok("Appointment with " + appointmentSummary.getId() + " has been updated. ");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping
	ResponseEntity<?> deleteAppointmentSummary(@RequestBody AppointmentSummary appointmentSummary) {
		try {
			appointmentSummaryService.delete(appointmentSummary);
			return ResponseEntity.ok("Appointment with " + appointmentSummary.getId() + " has been deleted. ");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
