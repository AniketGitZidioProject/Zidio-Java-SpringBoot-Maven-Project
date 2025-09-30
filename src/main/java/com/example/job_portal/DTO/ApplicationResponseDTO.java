package com.example.job_portal.DTO;

import ch.qos.logback.core.status.Status;

public class ApplicationResponseDTO {
	
	public Long id;
	public Long jobId;
	public String employeeEmail;
	public Status status;
	
	public ApplicationResponseDTO() {}
	public ApplicationResponseDTO(Long id,Long jobId,String employeeEmail,Status status) {
		this.id = id;
		this.jobId = jobId;
		this.employeeEmail = employeeEmail;
		this.status = status;
	}
}