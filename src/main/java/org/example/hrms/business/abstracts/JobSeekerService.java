package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

import java.util.List;

public interface JobSeekerService  {

    void signUp(User user,String type)throws Exception;
    DataResult<List<JobSeeker>> getAll();

}
