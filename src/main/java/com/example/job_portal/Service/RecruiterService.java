package com.example.job_portal.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.RecruiterDTO;
import com.example.job_portal.Entity.Recruiter;
import com.example.job_portal.Repository.RecruiterRepository;
import com.example.job_portal.Repository.UserRepository;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;
    
    @Autowired   // <-- Inject your UserRepository here
    private UserRepository userRepository;


    public Recruiter createOrUpdateRecruiter(RecruiterDTO dto) {
        Optional<Recruiter> existing = recruiterRepository.findByRecruiterEmail(dto.recruiterEmail);
        Recruiter recruiter = existing.orElse(new Recruiter());

        recruiter.setId(dto.id);
        recruiter.setRecruiterName(dto.recruiterName);
        recruiter.setCompanyName(dto.companyName);
        recruiter.setRecruiterEmail(dto.recruiterEmail);
        recruiter.setRecruiterPhone(dto.recruiterPhone);
        recruiter.setDesignation(dto.designation);
        
     // ✅ Set User if present
        if (dto.userId != null) {
            userRepository.findById(dto.userId)
                .ifPresent(recruiter::setUser); // sets the user if it exists
        } else {
            throw new RuntimeException("userId is required to create a Recruiter"); // optional safety
        }

        return recruiterRepository.save(recruiter);
    }

    public Recruiter getRecruiterByEmail(String recruiterEmail) {
        return recruiterRepository.findByRecruiterEmail(recruiterEmail)
                .orElseThrow(() -> new RuntimeException("Recruiter not Found"));
    }
}
