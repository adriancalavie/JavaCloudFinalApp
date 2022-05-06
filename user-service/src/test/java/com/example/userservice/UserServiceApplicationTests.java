package com.example.userservice;

import com.example.userservice.model.User;
import com.example.userservice.model.enums.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Test
	void contextLoads() {
		var user = UserType.MECHANIC;
		var userTypeStr = user.toString();
		
	}
	
}
