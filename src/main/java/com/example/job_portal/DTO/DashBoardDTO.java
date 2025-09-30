package com.example.job_portal.DTO;

public class DashBoardDTO {
	
	public long totalEmployees;
	public long totalRecruiters;
	public long totalJobs; 
	public long totalApplications;
	
	
	
	public DashBoardDTO() {}
	public DashBoardDTO(long totalEmployees, long totalRecruiters,long totalJobs, long totalApplications) {
		this.totalEmployees = totalEmployees;
		this.totalRecruiters = totalRecruiters;
		this.totalJobs = totalJobs;
		this.totalApplications = totalApplications;
		
	}
	
	public long getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(long totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public long getTotalRecruiters() {
		return totalRecruiters;
	}
	public void setTotalRecruiters(long totalRecruiters) {
		this.totalRecruiters = totalRecruiters;
	}
	public long getTotalJobs() {
		return totalJobs;
	}
	public void setTotalJobs(long totalJobs) {
		this.totalJobs = totalJobs;
	}
	public long getTotalApplications() {
		return totalApplications;
	}
	public void setTotalApplications(long totalApplications) {
		this.totalApplications = totalApplications;
	}
	
	
	

}
