package com.spring_boot_jpa.Spring.Boot.JPA.service;

import com.spring_boot_jpa.Spring.Boot.JPA.model.JobPost;
import com.spring_boot_jpa.Spring.Boot.JPA.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    public List<JobPost> getAllJobPost() {
        return jobPostRepository.findAll();
    }

    public Optional<JobPost> getJobPostById(Integer jobId) {
        return jobPostRepository.findById(jobId);
    }

    public JobPost saveJobPost(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

    public String deleteJobPostById(Integer jobId) {
        jobPostRepository.deleteById(jobId);
        return "Successfully Deleted JobId: " + jobId;
    }

    public JobPost updateJobPostById( JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }
}
