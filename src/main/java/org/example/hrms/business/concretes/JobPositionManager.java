package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.JobPositionService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.JobPositionDao;
import org.example.hrms.entities.concretes.JobPosition;
import org.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public void checkPositionName(JobPosition jobPosition) {

    }

    @Override
    public DataResult<List<JobPosition>> getALL() {
        return new SuccessDataResult<List<JobPosition>>("Data listelendi",this.jobPositionDao.findAll());
    }
}
