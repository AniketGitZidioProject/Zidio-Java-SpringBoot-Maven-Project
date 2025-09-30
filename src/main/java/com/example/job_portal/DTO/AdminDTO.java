package com.example.job_portal.DTO;

import com.example.job_portal.Entity.User;
import com.example.job_portal.Enum.Role;

public class AdminDTO {
	
	public Long id;
	public String email;
	public Role  role;
	public boolean active;
	public User user;
	
	
	public AdminDTO() {}
	public AdminDTO(Long id,String email, Role  role,boolean active, User user ) {
		this.id = id;
		this.email = email;
		this.role = role;
		this.active = active;
		this.user = user;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
