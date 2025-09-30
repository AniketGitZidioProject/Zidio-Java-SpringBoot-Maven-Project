package com.example.job_portal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_portal.DTO.EmployeeDTO;
import com.example.job_portal.Service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO dto) {
		return ResponseEntity.ok(employeeService.createEmployee(dto));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<EmployeeDTO>getEmployeeByEmail(@PathVariable String email){
		return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<EmployeeDTO>getEmployeeById(@PathVariable Long id){
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<EmployeeDTO>updateProfile(@RequestBody EmployeeDTO dto){
		return ResponseEntity.ok(employeeService.updateProfile(dto));
	}

}
