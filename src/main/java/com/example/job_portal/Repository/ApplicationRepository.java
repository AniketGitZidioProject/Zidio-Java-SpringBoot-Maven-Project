package com.example.job_portal.Repository;

import java.util.List;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job_portal.Entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    
    List<Application> findByEmployeeEmail(String employeeEmail);
    List<Application> findByRecruiterEmail(String recruiterEmail);
    List<Application> findByJobId(Long jobId);

    // ❌ remove this one, JPA already gives you findById()
    // Optional<Application> findByApplicationId(Long id);
    
    // ✅ use built-in findById(Long id) from JpaRepository
}
