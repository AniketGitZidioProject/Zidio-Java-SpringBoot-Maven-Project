package com.example.job_portal.DTO;

public class AuthResponse {
	
	public String token;
	
	
	public AuthResponse() {}
	public AuthResponse(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
