package com.example.userservice.controller;

import com.example.userservice.exception.AlreadyThereException;
import com.example.userservice.exception.NotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/api/users")
public class UserController {
	
	final UserService userService;
	
//	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("{id}")
	ResponseEntity<?> getUser(@PathVariable String id) {
		try {
			return ResponseEntity.ok(userService.read(id));
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	ResponseEntity<?> postUser(@RequestBody User user) {
		try {
			userService.create(user);
			return ResponseEntity.ok("User with id: " + user.getId() + " has been created.");
		} catch (AlreadyThereException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@PutMapping
	ResponseEntity<?> putUser(@RequestBody User user) {
		try {
			userService.update(user);
			return ResponseEntity.ok("User with id: " + user.getId() + " has been updated.");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@DeleteMapping()
	ResponseEntity<?> deleteUser(@RequestBody User user) {
		try {
			userService.delete(user);
			return ResponseEntity.ok("User with id: " + user.getId() + " has been deleted.");
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
