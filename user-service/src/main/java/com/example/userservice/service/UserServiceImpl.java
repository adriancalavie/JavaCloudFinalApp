package com.example.userservice.service;

import com.example.userservice.exception.AlreadyThereException;
import com.example.userservice.exception.NotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	@Override
	public void create(User user) throws AlreadyThereException {
		userRepository.add(user);
	}
	
	@Override
	public User read(String id) throws NotFoundException {
		return userRepository.get(id);
	}
	
	@Override
	public void update(User user) throws NotFoundException {
		userRepository.update(user);
	}
	
	@Override
	public void delete(User user) throws NotFoundException {
		userRepository.delete(user);
	}
}
