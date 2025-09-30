package com.example.job_portal.Repository;

import com.example.job_portal.Entity.Admin;
import com.example.job_portal.Enum.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // Find all admins with a specific role
    List<Admin> findByRole(Role role);

    // No need to override findById, JpaRepository already provides it
}
