package com.example.job_portal.Repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.job_portal.Entity.AuditLog;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
	
	List<AuditLog>findByActor(String actor);
	List<AuditLog>findByModule(String module);

}
