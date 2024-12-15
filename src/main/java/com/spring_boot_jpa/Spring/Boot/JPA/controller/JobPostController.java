package com.spring_boot_jpa.Spring.Boot.JPA.controller;

import com.spring_boot_jpa.Spring.Boot.JPA.model.JobPost;
import com.spring_boot_jpa.Spring.Boot.JPA.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/jobs")
public class JobPostController {

    @Autowired
    private JobPostService service;

    /*@GetMapping("/jobposts")
    public List<JobPost> getAllJobPost() {
        return jobPostService.getAllJobPost();
    }

    @GetMapping("/jobpost/{id}")
    public Optional<JobPost> getJobPostId(@PathVariable("id") Integer jobId) {
        return jobPostService.getJobPostById(jobId);
    }

    @PostMapping("/jobposts")
    public JobPost saveJobPost(@RequestBody JobPost jobPost) {
        return jobPostService.saveJobPost(jobPost);
    }

    @PutMapping("/updateJobPost/{id}")
    public JobPost updateJobPost(@RequestBody JobPost jobPost, @PathVariable("id") Integer jobId){
        return jobPostService.updateJobPostById(jobPost, jobId);
    }

    @DeleteMapping("/jobpost/{id}")
    public String deleteJobPost(@PathVariable("id") Integer jobId) {
        jobPostService.deleteJobPostById(jobId);
        return "JobId: " + jobId;
    }*/

    @GetMapping("/view")
    public String listJob(Model model) {
        List<JobPost> jobPosts = service.getAllJobPost();
        model.addAttribute("jobs", jobPosts);
        return "job/list";
    }

    @GetMapping("/add")
    public String showJobs(Model model) {
        model.addAttribute("job", new JobPost());
        return "job/add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("job") JobPost jobPost) {
        service.saveJobPost(jobPost);
        return "redirect:/jobs/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<JobPost> jobPost = service.getJobPostById(id);
        model.addAttribute("job", jobPost);
        return "job/edit";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@PathVariable Integer id, @ModelAttribute("jobPost") JobPost jobPost) {
        service.updateJobPostById(jobPost);
        return "redirect:/jobs/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteJobPostById(id);
        return "redirect:/jobs/view";
    }
}
