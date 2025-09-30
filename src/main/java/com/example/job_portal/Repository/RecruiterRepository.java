package com.example.job_portal.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;   // ✅ Correct import
import org.springframework.stereotype.Repository;

import com.example.job_portal.Entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
	// Match the entity field name (recruiterEmail)
    Optional<Recruiter> findByRecruiterEmail(String recruiterEmail);

}
