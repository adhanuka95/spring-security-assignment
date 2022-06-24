package com.training.security.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.security.assignment.jwt_bearer.JWTUtils;

@RestController
public class ReadRestController {

	@GetMapping("/")
	public String getHelloWorld() {
		return "Hello World";
	}

	@PostMapping("/login")
	public String tokenGenerator(@RequestParam String username) {
		System.out.println("Inside token generator, username: " + username);
		return JWTUtils.generateToken(username);
	}

	@GetMapping("/hello/{username}")
	public ResponseEntity<String> helloUser(@RequestParam String username) {

		String userPrincipal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (username.equals(userPrincipal)) {
			return ResponseEntity.ok("hello" + userPrincipal);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
