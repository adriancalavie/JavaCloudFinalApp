package com.example.userservice.repository;

import com.example.userservice.exception.AlreadyThereException;
import com.example.userservice.exception.NotFoundException;
import com.example.userservice.model.User;
import com.example.userservice.model.enums.UserType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private final List<User> users;
	
	UserRepositoryImpl() {
		users = new ArrayList<>();
		
		users.add(User.builder()
				.id("123")
				.firstName("Gary")
				.lastName("York")
				.email("gary.york@gmail.com")
				.address("4720 Cole Parkways, Apt. 176, 51962, Angelitafurt, Indiana, United States")
				.type(UserType.MECHANIC)
				.build());
		
		users.add(User.builder()
				.id("124")
				.firstName("Mike")
				.lastName("North")
				.email("mike.york@gmail.com")
				.address("7210 Orpha Ville, Apt. 396, 80017-2714, Howeshire, Arkansas, United States")
				.type(UserType.OWNER)
				.build());
		
		users.add(User.builder()
				.id("125")
				.firstName("Ryan")
				.lastName("Smith")
				.email("ryan.smith@gmail.com")
				.address("7300 Schuster Island, Suite 527, 45969, Bayertown, New Jersey, United States")
				.type(UserType.OWNER)
				.build());
	}
	
	@Override
	public List<User> getAll() {
		return users;
	}
	
	@Override
	public void add(User user) throws AlreadyThereException {
		var userOfId = findById(user.getId());
		
		if (userOfId.isPresent())
			throw new AlreadyThereException(User.class, user.getId());
		
		users.add(user);
	}
	
	@Override
	public void update(User user) {
		if (findById(user.getId()).isEmpty()) throw new NotFoundException(User.class, user.getId());
		
		users.stream()
				.filter(u -> u.getId().equals(user.getId()))
				.forEach(u -> u = user);
	}
	
	@Override
	public void delete(User user) throws NotFoundException {
		if (findById(user.getId()).isEmpty()) throw new NotFoundException(User.class, user.getId());
		
		users.remove(user);
	}
	
	@Override
	public User get(String id) {
		var userOfId = findById(id);
		
		if (userOfId.isEmpty())
			throw new NotFoundException(User.class, id);
		
		return userOfId.get();
	}
	
	@Override
	public Optional<User> findById(String id) {
		return users.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst();
	}
}
