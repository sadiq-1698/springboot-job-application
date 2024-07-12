package com.sadiq1698.firstjobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //  Get all jobs
    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    //  Create a job
    @PostMapping("/job")
    public String addJob(@RequestBody  Job _job) {
        jobService.createJob(_job);
        return "Job Added Successfully";
    }

    //  Get a job by ID
    @GetMapping("/jobs/{id}")
    public Job findAJob(@PathVariable Long id) {
        return jobService.getJobyId(id);
    }



//    //  Update a job
//    @PatchMapping("/job/:id")
//    public void updateJob(String id) {
//
//    }
//
//    //  Delete a job
//    @DeleteMapping("/job/:id")
//    public void deleteJob(String id) {
//
//    }
}
