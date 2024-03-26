package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.Result;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

import java.util.List;

public interface JobSeekerService  {

    DataResult<JobSeeker> signUp(JobSeeker jobSeeker)throws Exception;
    DataResult<List<JobSeeker>> getAll();
    DataResult<JobSeeker> add(JobSeeker jobSeeker);

    DataResult<JobSeeker> findById(int id);

    DataResult<JobSeeker> findByUserId(int userId);



}
