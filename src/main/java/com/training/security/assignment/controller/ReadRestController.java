package com.training.security.assignment.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.security.assignment.jwt_bearer.JwtTokenUtil;

@RestController
public class ReadRestController {

	@GetMapping("/")
	public String getHelloWorld() {
		
		return "Hello World";
	}

	@PostMapping("/login")
	public ResponseEntity<String> tokenGenerator(@RequestParam String username) {
		
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, JwtTokenUtil.generateToken(username))
				.body("Login Successful!!");
	}

	@GetMapping("/hello")
	public ResponseEntity<String> helloUser(@RequestParam String username) {
		
		String userPrincipal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (username.equals(userPrincipal)) {
			return ResponseEntity.ok("hello " + userPrincipal);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
