package com.example.job_portal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_portal.DTO.ApplicationTrackDTO;
import com.example.job_portal.DTO.DashBoardDTO;

import com.example.job_portal.Service.AnalyticService;

@RestController
@RequestMapping("/api/Dashboard")
public class AnalyticController {
	
	
	@Autowired
	private AnalyticService analyticService;
	
	
	@GetMapping("/summary")
	
	public ResponseEntity<DashBoardDTO>getSummary(){
		return ResponseEntity.ok(analyticService.getSummary());
	}
	
	@GetMapping("/applications/weekly")
	public ResponseEntity<List<ApplicationTrackDTO>> getWeeklyTrackers(){
		return ResponseEntity.ok(analyticService.getWeeklyApplicationTracker());
	}
	

}
