package com.example.job_portal.DTO;

import java.time.LocalDate;

import com.example.job_portal.Enum.JobType;

public class JobPostDTO {
	
	public Long id;
	public String recruiterEmail;
	public String companyName;
	public String jobTitle;
	public JobType jobType;
	public String jobDescription;
	public String jobLocation;
	public LocalDate postedDate;
	public LocalDate deadLineDate;
	
	
	public JobPostDTO() {}
	public JobPostDTO(Long id,String recruiterEmail, String companyName, String jobTitle,  JobType jobType, String jobDescription, String jobLocation, LocalDate postedDate, LocalDate deadLineDate) {
		this.id = id;
		this.recruiterEmail = recruiterEmail;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.postedDate = postedDate;
		this.deadLineDate = deadLineDate;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public JobType getJobType() {
		return jobType;
	}
	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public LocalDate getDeadLineDate() {
		return deadLineDate;
	}
	public void setDeadLineDate(LocalDate deadLineDate) {
		this.deadLineDate = deadLineDate;
	}
	
	
	

}
