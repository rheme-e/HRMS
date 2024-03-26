package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.JobAdvertisementService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import org.example.hrms.entities.concretes.JobAdvertisement;
import org.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public List<JobAdvertisement> getAll() {
        return jobAdvertisementDao.findAll();
    }

    @Override
    public List<JobAdvertisement> findAllByIsActiveTrue() {
        return jobAdvertisementDao.findAllByIsActiveTrue();
    }

    @Override
    public List<JobAdvertisement> findAllByIsActiveTrueSortByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
        return jobAdvertisementDao.findAllByIsActiveTrue(sort);
    }

    @Override
    public List<JobAdvertisement> findAllByEmployer_Id(int employerId) {
        return jobAdvertisementDao.findAllByEmployer_Id(employerId);
    }
    @Override
    public DataResult<JobAdvertisement> findById(int id) {
        return new SuccessDataResult<JobAdvertisement>("ok",jobAdvertisementDao.findById(id));
    }


    @Override
    public DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessDataResult<JobAdvertisement>("İş ilanı eklendi",jobAdvertisement);
    }
}
