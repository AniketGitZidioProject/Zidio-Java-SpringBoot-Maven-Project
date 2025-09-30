package com.example.job_portal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.EmployeeDTO;
import com.example.job_portal.Entity.Employee;
import com.example.job_portal.Entity.User;
import com.example.job_portal.Repository.EmployeeRepository;
import com.example.job_portal.Repository.UserRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		Employee employee = new Employee(dto.id, dto.name, dto.email, dto.phone, dto.qualification, dto.getResumeURL(), dto.user);
		Employee saved = employeeRepository.save(employee);

		return new EmployeeDTO(saved.getId(),
				saved.getName(),
				saved.getEmail(),
				saved.getPhone(),
				saved.getQualification(),
				saved.getResumeURL(),
				saved.getUser());
	}
	public EmployeeDTO getEmployeeByEmail(String email) {
		Employee emp = employeeRepository.findByEmail(email);
		if(emp==null)
			return null;
		return new EmployeeDTO(
				 emp.getId(), 
				 emp.getName(), 
				 emp.getEmail(), 
				 emp.getPhone(), 
				 emp.getQualification(), 
				 emp.getResumeURL(),
				 emp.getUser());
		
		
				      	        	        		
	}
	
	public EmployeeDTO getEmployeeById(Long id) {
        Employee empl = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return new EmployeeDTO(empl.getId(),
				empl.getName(),
				empl.getEmail(),
				empl.getPhone(),
				empl.getQualification(),
				empl.getResumeURL(),
				empl.getUser());// now included
    }
	
	public EmployeeDTO updateProfile(EmployeeDTO dto) {
//		//if (employeeRepository.existsByEmail(newEmail) && !oldEmail.equals(newEmail)) {
//		    throw new RuntimeException("Email already exists");
//		}
		Employee emp = employeeRepository.findById(dto.id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));
		
		// If the DTO includes a user id, load that User and set it
	    if (dto.user != null && dto.user.getId() != null) {
	        User user = userRepository.findById(dto.user.getId())
	                .orElseThrow(() -> new RuntimeException("User not found"));
	        emp.setUser(user);
	    } else {
	        // keep the existing user so user_id never becomes null
	        emp.setUser(emp.getUser());
	    }
		
//		if(emp==null) {
//			emp = new Employee();
//			emp.setEmail(dto.email);
//		}
		
		emp.setId(dto.id);
		emp.setName(dto.name);
		emp.setEmail(dto.email);
		emp.setPhone(dto.phone);
		emp.setQualification(dto.qualification);
		emp.setResumeURL(dto.resumeURL);
		
		Employee saved  = employeeRepository.save(emp);
		
		return new EmployeeDTO(
				saved.getId(), 
				saved.getName(), 
				saved.getEmail(), 
				saved.getPhone(), 
				saved.getQualification(), 
				saved.getResumeURL(),
				saved.getUser());
	}

}
