package com.example.job_portal.DTO;

public class ApplicationRequestDTO {
	
	public Long jobId;
	public String employeeEmail;
	
	
	
	public ApplicationRequestDTO(){}
	public ApplicationRequestDTO(Long jobId,String employeeEmail ){
		this.jobId = jobId;
		this.employeeEmail = employeeEmail;
	}
	
	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	
	

}
