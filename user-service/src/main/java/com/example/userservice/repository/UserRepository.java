package com.example.userservice.repository;

import com.example.userservice.exception.AlreadyThereException;
import com.example.userservice.exception.NotFoundException;
import com.example.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	List<User> getAll();
	
	void add(User user);
	
	void update(User user);
	
	void delete(User id);
	
	User get(String id);
	
	Optional<User> findById(String id);
}
