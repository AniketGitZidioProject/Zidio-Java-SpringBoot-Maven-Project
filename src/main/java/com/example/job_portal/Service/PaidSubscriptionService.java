package com.example.job_portal.Service;

import java.io.ByteArrayInputStream;
//import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_portal.DTO.PaidSubscriptionDTO;
import com.example.job_portal.Entity.PaidSubscription;
import com.example.job_portal.Repository.PaidSubscriptionRepository;
import com.example.job_portal.Security.InvoiceGenerator;

@Service
public class PaidSubscriptionService {
	
	
	@Autowired
	private PaidSubscriptionRepository paidSubscriptionRepository;
	
	
	
	public PaidSubscriptionDTO createSubscription(PaidSubscriptionDTO dto) {
		PaidSubscription sub = new PaidSubscription();
		
		sub.setId(dto.id);
		sub.setEmployeeId(dto.employeeId);
		sub.setRecruiterId(dto.recruiterId);
		sub.setPlanId(dto.planId);
		sub.setUserEmail(dto.userEmail);
		sub.setPaymentStatus(dto.paymentStatus);
		sub.setStartDate(dto.startDate);
		sub.setEndDate(dto.endDate);
		sub.setInvoiceUrl(dto.invoiceUrl);
		
		sub.setAmount(dto.amount);
		sub.setCurrency(dto.currency);
		
		PaidSubscription saved  = paidSubscriptionRepository.save(sub);
		
		return mapToDTO(saved);
		
		
	}
	
	public List<PaidSubscriptionDTO>getSubscriptionByUserEmail(String userEmail){
		return  paidSubscriptionRepository.findByUserEmail(userEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<PaidSubscriptionDTO>getSubscriptionByEmployeeId(Long employeeId){
		return paidSubscriptionRepository.findByEmployeeId(employeeId).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<PaidSubscriptionDTO>getSubscriptionByRecruiterId(Long recruiterId){
		return paidSubscriptionRepository.findByRecruiterId(recruiterId).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<PaidSubscriptionDTO>getAll(){
		return paidSubscriptionRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		
	}
	
	public ByteArrayInputStream generateInvoice(Long id) {
		PaidSubscription subscription = paidSubscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription Not Found!"));
		return InvoiceGenerator.generateInvoice(subscription);
		
		
	}
	
	private PaidSubscriptionDTO mapToDTO(PaidSubscription sub) {
		PaidSubscriptionDTO dto = new PaidSubscriptionDTO();
		dto.setId(sub.getId());
		dto.setEmployeeId(sub.getEmployeeId());
		dto.setRecruiterId(sub.getRecruiterId());
		dto.setPlanId(sub.getPlanId());
		dto.setUserEmail(sub.getUserEmail());
		dto.setPaymentStatus(sub.getPaymentStatus());
		dto.setInvoiceUrl(sub.getInvoiceUrl());
		dto.setStartDate(sub.getStartDate());
		dto.setEndDate(sub.getEndDate());
		
		return dto;
		
	}

	

}
