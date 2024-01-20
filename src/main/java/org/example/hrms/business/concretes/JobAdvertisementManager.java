package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.JobAdvertisementService;
import org.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import org.example.hrms.entities.concretes.JobAdvertisement;
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
    public List<JobAdvertisement> findAllByIsActiveTrue() {
        return jobAdvertisementDao.findAllByIsActiveTrue();
    }

    @Override
    public List<JobAdvertisement> findAllByIsActiveTrueSortByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
        return jobAdvertisementDao.findAllByIsActiveTrue(sort);
    }

    @Override
    public List<JobAdvertisement> findAllByIsActiveTrueAndEmployer_Id(int employerId) {
        return jobAdvertisementDao.findAllByIsActiveTrueAndEmployer_Id(employerId);
    }
}
