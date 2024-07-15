package com.sadiq1698.firstjobapp.job.impl;

import com.sadiq1698.firstjobapp.job.Job;
import com.sadiq1698.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final List<Job> listOfJobs = new ArrayList<Job>();
    private Long newId = 0L;

    @Override
    public List<Job> findAll() {
        return listOfJobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(++newId);
        listOfJobs.add(job);
    }

    @Override
    public boolean deleteJob(Long id) {
        for (int index = 0; index < listOfJobs.size(); index++) {
            if (listOfJobs.get(index).getId().equals(id)) {
                listOfJobs.remove(index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job job) {
        for (int index = 0; index < listOfJobs.size(); index++) {
            if (listOfJobs.get(index).getId().equals(id)) {
                Job oldJob = listOfJobs.get(index);

                oldJob.setTitle(job.getTitle());
                oldJob.setDescription(job.getDescription());
                oldJob.setLocation(job.getLocation());
                oldJob.setMinSalary(job.getMinSalary());
                oldJob.setMaxSalary(job.getMaxSalary());

                return true;
            }
        }
        return false;
    }

    @Override
    public Job getJobyId(Long id) {
        for (Job job: listOfJobs) {
            if(job.getId().equals(id)) return job;
        }
        return null;
    }
}
