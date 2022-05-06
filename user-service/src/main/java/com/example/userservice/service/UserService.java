package com.example.userservice.service;

import com.example.userservice.model.User;

import java.util.List;

public interface UserService {
	List<User> getAll();
	
	void create(User user);
	
	User read(String id);
	
	void update(User user);
	
	void delete(User user);
}
