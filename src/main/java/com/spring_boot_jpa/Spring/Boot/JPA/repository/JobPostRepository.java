package com.spring_boot_jpa.Spring.Boot.JPA.repository;

import com.spring_boot_jpa.Spring.Boot.JPA.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
}
