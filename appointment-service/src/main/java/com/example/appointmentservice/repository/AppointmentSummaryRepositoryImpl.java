package com.example.appointmentservice.repository;

import com.example.appointmentservice.exception.AlreadyThereException;
import com.example.appointmentservice.exception.NotFoundException;
import com.example.appointmentservice.model.Appointment;
import com.example.appointmentservice.model.AppointmentSummary;
import com.example.appointmentservice.model.Car;
import com.example.appointmentservice.model.User;
import com.example.appointmentservice.model.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentSummaryRepositoryImpl implements AppointmentSummaryRepository {
	final List<AppointmentSummary> appointments;
	
	@Autowired
	public AppointmentSummaryRepositoryImpl() {
		this.appointments = new ArrayList<>();
		User client = User.builder()
				.id("123")
				.firstName("Gary")
				.lastName("York")
				.email("gary.york@gmail.com")
				.address("4720 Cole Parkways, Apt. 176, 51962, Angelitafurt, Indiana, United States")
				.type(UserType.MECHANIC)
				.build();
		
		Appointment appointment = Appointment.builder()
				.id("222")
				.user(client)
				.car(new Car("421", "Dacia"))
				.startDate(LocalDateTime.now())
				.endDate(LocalDateTime.now())
				.build();
				
		
		User mechanic = User.builder()
				.id("123")
				.firstName("Gary")
				.lastName("York")
				.email("gary.york@gmail.com")
				.address("4720 Cole Parkways, Apt. 176, 51962, Angelitafurt, Indiana, United States")
				.type(UserType.MECHANIC)
				.build();
		
		AppointmentSummary appointmentSummary = AppointmentSummary.builder()
				.id("111")
				.appointment(appointment)
				.mechanic(mechanic)
				.comment("Mare defectie la turbo suflantă, vericule")
				.totalCost(50000D)
				.build();
		
		appointments.add(appointmentSummary);
	}
	
	@Override
	public List<AppointmentSummary> getAll() {
		return appointments;
	}
	
	@Override
	public void add(AppointmentSummary appointment) throws AlreadyThereException {
		var appointmentOfId = findById(appointment.getId());
		
		if (appointmentOfId.isPresent())
			throw new AlreadyThereException(AppointmentSummary.class, appointment.getId());
		
		appointments.add(appointment);
	}
	
	
	@Override
	public void update(AppointmentSummary appointment) throws NotFoundException {
		if (findById(appointment.getId()).isEmpty())
			throw new NotFoundException(AppointmentSummary.class, appointment.getId());
		
		
		appointments.stream()
				.filter(a -> a.getId().equals(appointment.getId()))
				.forEach(a -> a = appointment);
	}
	
	@Override
	public void delete(AppointmentSummary appointment) throws NotFoundException {
		Optional<AppointmentSummary> appointmentSummary = findById(appointment.getId());
		if (appointmentSummary.isEmpty())
			throw new NotFoundException(AppointmentSummary.class, appointment.getId());
		
		appointments.remove(appointmentSummary.get());
	}
	
	@Override
	public AppointmentSummary get(String id) throws NotFoundException {
		var appointmentOfId = findById(id);
		
		if (appointmentOfId.isEmpty())
			throw new NotFoundException(AppointmentSummary.class, id);
		
		return appointmentOfId.get();
	}
	
	@Override
	public Optional<AppointmentSummary> findById(String id) {
		return appointments.stream()
				.filter(appointment -> appointment.getId().equals(id))
				.findFirst();
	}
}
