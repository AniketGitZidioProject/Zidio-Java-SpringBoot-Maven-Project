package com.example.job_portal.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.AdminDTO;
import com.example.job_portal.DTO.SystemStatusDTO;
import com.example.job_portal.DTO.UserStatusUpdateDTO;
import com.example.job_portal.Entity.Admin;
import com.example.job_portal.Enum.Role;
import com.example.job_portal.Repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get all admins
    public List<AdminDTO> getAllUsers() {
        return adminRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get admins by role
    public List<AdminDTO> getUserByRole(Role role) {
        if (role == null) return Collections.emptyList();
        return adminRepository.findByRole(role).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Update user status
    public AdminDTO updateUserStatus(UserStatusUpdateDTO dto) {
        Optional<Admin> optional = adminRepository.findById(dto.getUserId());
        if (!optional.isPresent()) {
            throw new RuntimeException("User Not Found with ID " + dto.getUserId());
        }

        Admin user = optional.get();
        user.setActive(dto.isActive());
        adminRepository.save(user);

        return toDTO(user);
    }

    // Get system status
    public SystemStatusDTO getSystemStatus() {
        int totalUsers = (int) adminRepository.count();
        int totalEmployees = (int) adminRepository.findByRole(Role.EMPLOYEE).size();
        int totalRecruiters = (int) adminRepository.findByRole(Role.RECRUITER).size();
        int totalAdmins = (int) adminRepository.findByRole(Role.ADMIN).size();

        SystemStatusDTO status = new SystemStatusDTO();
        status.setTotalUsers(totalUsers);
        status.setTotalEmployee(totalEmployees);
        status.setTotalRecruiters(totalRecruiters);
        status.setTotalUsers(totalAdmins);
        return status;
    }

    // Convert Admin entity to DTO
    private AdminDTO toDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        dto.setActive(admin.isActive());
        return dto;
    }
}
