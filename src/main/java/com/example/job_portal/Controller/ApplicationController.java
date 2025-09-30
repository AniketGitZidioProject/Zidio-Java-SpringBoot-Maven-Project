package com.example.job_portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_portal.DTO.ApplicationDTO;
import com.example.job_portal.DTO.UpdateApplicationStatusDTO;
import com.example.job_portal.Service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping("/apply")
	public ResponseEntity<ApplicationDTO>apply(@RequestBody ApplicationDTO dto){
		return ResponseEntity.ok(applicationService.applyJob(dto));
	}
	
	@GetMapping("/job/employee/{employeeEmail}")
	public ResponseEntity<List<ApplicationDTO>>getByEmployeeEmail(@PathVariable String employeeEmail){
		return ResponseEntity.ok(applicationService.getByEmployeeEmail(employeeEmail));
	}
	
	@GetMapping("/job/recruiter/{recruiterEmail}")
	public ResponseEntity<List<ApplicationDTO>>getByRecruiterEmail(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(applicationService.getByRecruiterEmail(recruiterEmail));
	}
	
	@GetMapping("/job/{jobId}")
	public ResponseEntity<List<ApplicationDTO>>getByJobId(@PathVariable Long jobId){
		return ResponseEntity.ok(applicationService.getByJobId(jobId));
	}
	
	@PutMapping("/status")
	public ResponseEntity<String>updateApplicationStatus(@RequestBody UpdateApplicationStatusDTO dto){
		applicationService.updateApplicationStatus(dto);
		return ResponseEntity.ok("Status Updated");
	}

}
