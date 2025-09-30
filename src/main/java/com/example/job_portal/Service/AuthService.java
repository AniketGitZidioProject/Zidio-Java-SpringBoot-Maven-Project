package com.example.job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.AuthResponse;
import com.example.job_portal.DTO.LoginRequest;
import com.example.job_portal.DTO.RegisterRequest;
import com.example.job_portal.Entity.Admin;
import com.example.job_portal.Entity.Employee;
import com.example.job_portal.Entity.Recruiter;
import com.example.job_portal.Entity.User;
import com.example.job_portal.Enum.Role;
import com.example.job_portal.Repository.AdminRepository;
import com.example.job_portal.Repository.EmployeeRepository;
import com.example.job_portal.Repository.RecruiterRepository;
import com.example.job_portal.Repository.UserRepository;
import com.example.job_portal.Security.JWTUtil;


@Service
public class AuthService {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private RecruiterRepository recruiterRepo;
	
	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public AuthResponse register(RegisterRequest request) {
		User user = new User();
		 user.setName(request.name);
		 user.setEmail(request.email);
		 user.setPassword(passwordEncoder.encode(request.password));
		 user.setRole(request.role);
		 userRepository.save(user);
		 //if - else segregation
		 if (request.role == Role.EMPLOYEE) {
			 Employee emp = new Employee();
			 emp.setUser(user);
			 emprepo.save(emp);
			 
		 }else if(request.role == Role.RECRUITER) {
			 Recruiter recr = new Recruiter();
			 recr.setUser(user);
			 recruiterRepo.save(recr); 
			 
			  
		 } else if(request.role == Role.ADMIN) {
			 Admin admin = new Admin();
			 admin.setUser(user);
			 adminRepo.save(admin);
		 }
		 
		 String token = jwtUtil.generateToken( user.getEmail(),user.getRole().name());
		 return  new AuthResponse(token);
		 
		  
	 }
	 
	 public AuthResponse login(LoginRequest request) {
		 
		 User user = userRepository.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User not found"));
		 
		 
		 if(!passwordEncoder.matches(request.password, user.getPassword()))
			 throw new RuntimeException("Invalid credentials");
		 
		 String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
		 return new AuthResponse(token);	 
		 
	 }
}
