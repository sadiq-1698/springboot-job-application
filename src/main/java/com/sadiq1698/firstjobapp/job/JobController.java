package com.sadiq1698.firstjobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class JobController {
    private List<Job> listOfJobs = new ArrayList<Job>();

    //  Get all jobs
    @GetMapping("/jobs")
    public List<Job> findAll() {
        return listOfJobs;
    }

    //  Get a job by ID
    @GetMapping("/jobs/:id")
    public Job findAJob(String id) {
        return listOfJobs.get(0);
    }

    //  Create a job
    @PostMapping("/job")
    public String addJob(@RequestBody  Job _job) {
        listOfJobs.add(_job);
        return "Job Added Successfully";
    }

    //  Update a job
    @PatchMapping("/job/:id")
    public void updateJob(String id) {

    }

    //  Delete a job
    @DeleteMapping("/job/:id")
    public void deleteJob(String id) {

    }
}
