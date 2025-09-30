package com.example.job_portal.DTO;

public class SubscriptionPlanDTO {
	
	public Long id;
	public String name;
	
	public int maxJob;
	public int maxProfile;
	public int validityDays;
	public double prices;
	
	
	public  SubscriptionPlanDTO() {}
	public  SubscriptionPlanDTO(Long id,String name, int maxJob,int maxProfile,int validityDays,double prices) {
		
		this.id = id;
		this.name = name;
		this.maxJob = maxJob;
		this.maxProfile = maxProfile;
		this.validityDays = validityDays;
		this.prices = prices;
		
		
	}

}
