package com.example.job_portal.DTO;

import com.example.job_portal.Enum.Role;

public class RegisterRequest {
	
	public String name;
	public String email;
	public String password;
	public Role role;
	
	public RegisterRequest() {}
	public RegisterRequest( String name, String password, String email, Role role) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
