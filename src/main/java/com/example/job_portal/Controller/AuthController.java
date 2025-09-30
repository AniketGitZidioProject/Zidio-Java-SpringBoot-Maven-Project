package com.example.job_portal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_portal.DTO.AuthResponse;
import com.example.job_portal.DTO.LoginRequest;
import com.example.job_portal.DTO.RegisterRequest;
import com.example.job_portal.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authservice;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse>register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authservice.register(request));
	}
	@PostMapping("/login")
	public ResponseEntity<AuthResponse>login(@RequestBody LoginRequest request){
		return ResponseEntity.ok(authservice.login(request));
		
	}

}
