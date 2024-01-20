package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.JobSeekerService;
import org.example.hrms.business.abstracts.UserCheckService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.JobSeekerDao;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private UserCheckService userCheckService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService=userCheckService;

    }


    public void signUp(User user,String type) throws Exception {
        if(this.userCheckService.isSignUp(user,type)){

        }
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>("Data listelendi",this.jobSeekerDao.findAll());
    }
}
