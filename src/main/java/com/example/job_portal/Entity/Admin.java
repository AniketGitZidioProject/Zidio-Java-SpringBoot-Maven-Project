package com.example.job_portal.Entity;

import com.example.job_portal.Enum.Role;
import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)  // Email should be unique
    private String email;

    @Enumerated(EnumType.STRING)  // Store Role as string instead of ordinal
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean active = true;
    
    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",nullable=false)
	private User user;

    // Default constructor
    public Admin() {}

    // Parameterized constructor
    public Admin(Long id, String email, Role role, boolean active, User user) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.active = active;
        this.user = user;
    }
    
    // Getters & Setters
    
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
