package com.example.job_portal.Repository;

//import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.job_portal.DTO.PaidSubscriptionDTO;
import com.example.job_portal.Entity.PaidSubscription;

@Repository
public interface PaidSubscriptionRepository extends JpaRepository<PaidSubscription,Long> {
	List<PaidSubscription>findByRecruiterId(Long recruiterId);
	List<PaidSubscription>findByEmployeeId(Long employeeId);
	List<PaidSubscription>findByUserEmail(String userEmail);
	List<PaidSubscription>findAll();
	//List<PaidSubscription> findAll();
	 // Optional<PaidSubscription> findById(Long id); ← inherited
	//PaidSubscription save(PaidSubscription sub);
//	PaidSubscription findById(Long id);
	Optional<PaidSubscription> findById(Long id);
	//List<PaidSubscriptionDTO> findAll();
	//Collection<PaidSubscriptionDTO> findAll();
	
	

}
