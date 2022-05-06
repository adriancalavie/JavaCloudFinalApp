package com.example.userservice.model;

import com.example.userservice.model.enums.UserType;
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
