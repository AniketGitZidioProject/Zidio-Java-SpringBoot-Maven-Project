package com.example.job_portal.Entity;

import javax.persistence.*;

import com.example.job_portal.Enum.ApplicationStatus;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;

    private String employeeEmail;

    private String recruiterEmail;

    // ✅ This is an enum, keep @Enumerated
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    
    // ✅ This is just a String (URL or file path), no @Enumerated
    private String resumeURL;

    // ---- Constructors ----
    public Application() {}

    public Application(Long id, Long jobId, String employeeEmail,ApplicationStatus status,
                       String recruiterEmail, String resumeURL)  {
                      
        this.id = id;
        this.jobId = jobId;
        this.employeeEmail = employeeEmail;
        this.recruiterEmail = recruiterEmail;
        this.resumeURL = resumeURL;
        this.status = status;
    }

    // ---- Getters & Setters ----
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }
    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public ApplicationStatus getStatus() {
        return status;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    
    public String getResumeURL() {
        return resumeURL;
    }
    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }
}
