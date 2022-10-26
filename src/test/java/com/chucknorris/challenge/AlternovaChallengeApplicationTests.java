package com.chucknorris.challenge;

import com.chucknorris.challenge.model.domain.User;
import com.chucknorris.challenge.model.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class AlternovaChallengeApplicationTests {
	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	@Test
	void saveUserTest() {
		//Arrange
		User newUser= new User();
		newUser.setEmail("ramirezjuan@gmail.com");
		newUser.setPassword(encoder.encode("123"));
		//Act
		User userDatabase=repository.save(newUser);
		//Assert
		Assertions.assertEquals("ramirezjuan@gmail.com",userDatabase.getEmail());

	}

}
