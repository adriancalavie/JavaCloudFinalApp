package com.example.appointmentservice.model;

import com.example.appointmentservice.model.enums.UserType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	String id;
	String firstName;
	String lastName;
	String email;
	String address;
	UserType type;
}
