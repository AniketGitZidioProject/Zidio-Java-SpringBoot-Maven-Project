package com.example.job_portal.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.ApplicationDTO;
import com.example.job_portal.DTO.UpdateApplicationStatusDTO;
import com.example.job_portal.Entity.Application;
import com.example.job_portal.Enum.ApplicationStatus;
import com.example.job_portal.Repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	public ApplicationDTO applyJob(ApplicationDTO dto) {
		Application app = new Application();
		app.setId(dto.id);
		app.setJobId(dto.jobId);
		app.setEmployeeEmail(dto.employeeEmail);
		app.setRecruiterEmail(dto.recruiterEmail);
//		if (dto.getStatus() != null) {
//	        app.setStatus(ApplicationStatus.valueOf(dto.getStatus().toString()));
//	    } else {
//	        app.setStatus(ApplicationStatus.APPLIED);
//	    }
		app.setStatus(dto.status);
		app.setResumeURL(dto.resumeURL);
		
		applicationRepository.save(app);
		
		return mapToDTO(app);
		
	}
	
	public List<ApplicationDTO> getByEmployeeEmail(String employeeEmail){
		return applicationRepository.findByEmployeeEmail(employeeEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ApplicationDTO>getByRecruiterEmail(String recruiterEmail){
		return applicationRepository.findByRecruiterEmail(recruiterEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ApplicationDTO>getByJobId(Long jobId){
		return applicationRepository.findByJobId(jobId).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public ApplicationDTO updateApplicationStatus(UpdateApplicationStatusDTO dto) {
		Optional<Application>optional = applicationRepository.findById(dto.getApplicationId());
		
		if(!optional.isPresent()) {
			throw new RuntimeException("Application not found");
		}
		
		Application app = optional.get();
		
		try {
			ApplicationStatus newStatus = ApplicationStatus.valueOf(dto.getStatus().toString());
			//app.setStatus(newStatus); //<- Adds clutter, making the code harder to read.
			app.setStatus(newStatus); //<- This makes the code clean and efficient 
		}
		
		catch(IllegalArgumentException e) {
			throw new RuntimeException("Invalid status" +dto.status);
		}
		applicationRepository.save(app);
		
		return mapToDTO(app);
		
	}

	private ApplicationDTO mapToDTO(Application app) {
	
		ApplicationDTO dto = new ApplicationDTO();
		
		dto.setId(app.getId());
		dto.setJobId(app.getJobId());
		dto.setEmployeeEmail(app.getEmployeeEmail());
		dto.setRecruiterEmail(app.getRecruiterEmail());
		dto.setStatus(app.getStatus());
		dto.setResumeURL(app.getResumeURL());
		
		return dto;
		
		
	}

}
