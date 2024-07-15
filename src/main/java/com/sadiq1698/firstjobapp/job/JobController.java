package com.sadiq1698.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/job/all")
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    //  Create a job
    @PostMapping("/job")
    public ResponseEntity<String> addJob(@RequestBody  Job _job) {
        jobService.createJob(_job);
        return new ResponseEntity<>("Job Added Successfully", HttpStatus.CREATED);
    }

    //  Get a job by ID
    @GetMapping("/job/{id}")
    public ResponseEntity<Job> findAJob(@PathVariable Long id) {
        Job job = jobService.getJobyId(id);
        if(job != null) return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //  Update a job
    @PutMapping("/job/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody  Job _job) {
        boolean isUpdated = jobService.updateJob(id, _job);
        if (isUpdated) return new ResponseEntity<String>("Job Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<String>("Failed Updating job", HttpStatus.NOT_FOUND);
    }

    //  Delete a job
    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJob(id);
        if (isDeleted) return new ResponseEntity<String>("Job Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<String>("Failed Deleting job", HttpStatus.NOT_FOUND);
    }
}
