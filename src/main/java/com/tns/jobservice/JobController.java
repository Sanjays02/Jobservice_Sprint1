package com.tns.jobservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class JobController {

    @Autowired
    private JobService jobService;

    // Get all jobs
    @GetMapping("/job")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Get a specific job by ID
    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return job != null ? ResponseEntity.ok(job) : ResponseEntity.notFound().build();
    }

    // Create a new job
    @PostMapping("/job")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    // Update an existing job by ID
    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job jobDetails) {
        Job updatedJob = jobService.updateJob(id, jobDetails);
        return updatedJob != null ? ResponseEntity.ok(updatedJob) : ResponseEntity.notFound().build();
    }

    // Delete a job by ID
    @DeleteMapping("/job/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
