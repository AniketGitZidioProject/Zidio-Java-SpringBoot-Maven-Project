package com.example.job_portal.DTO;

public class CreateApplicationDTO {
	
	public Long jobId;
	public String employeeEmail;
	public String recruiterEmail;
	public String resumeURL;
	
	public CreateApplicationDTO() {}
	public CreateApplicationDTO(Long jobId, String employeeEmail,String recruiterEmail, String resumeURL ) {
		this.jobId = jobId;
		this.employeeEmail = employeeEmail;
		this.recruiterEmail = recruiterEmail;
		this.resumeURL = resumeURL;
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
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getResumeURL() {
		return resumeURL;
	}
	public void setResumeURL(String resumeURL) {
		this.resumeURL = resumeURL;
	}
	
	

}
