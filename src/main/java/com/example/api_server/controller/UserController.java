package com.example.api_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_server.model.User;
import com.example.api_server.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
	private final UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		log.info("* createdUser");
		log.debug(user.toString());
		User savedUser = userRepository.save(user);
		log.debug(savedUser.toString());
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
}
