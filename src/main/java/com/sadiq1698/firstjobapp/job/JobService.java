package com.sadiq1698.firstjobapp.job;

import java.util.List;

public interface JobService {
   List<Job> findAll();
   void createJob(Job job);
   boolean deleteJob(Long id);
   boolean updateJob(Long id, Job job);
   Job getJobyId(Long id);
}
