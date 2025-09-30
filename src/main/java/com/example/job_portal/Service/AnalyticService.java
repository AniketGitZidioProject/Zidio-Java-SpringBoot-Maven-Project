package com.example.job_portal.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.ApplicationTrackDTO;
import com.example.job_portal.DTO.DashBoardDTO;

@Service
public class AnalyticService {
	
	public DashBoardDTO getSummary() {
		
		DashBoardDTO dto = new DashBoardDTO();
		
		dto.setTotalEmployees(1000);
		dto.setTotalRecruiters(500);
		dto.setTotalJobs(400);
		dto.setTotalApplications(5000);
		
		return dto;
	}
	
	public List<ApplicationTrackDTO>getWeeklyApplicationTracker(){
		
		List<ApplicationTrackDTO> tracker = new ArrayList<>();
		
		for(int i=6; i>=0; i--) {
			
			ApplicationTrackDTO dto = new ApplicationTrackDTO(); 
			dto.setDate(LocalDate.now().minusDays(i).toString());
			dto.setApplications(50+(long)(Math.random()*100));
			
			
			tracker.add(dto);
		}
		
		
		return tracker;
	}

}
