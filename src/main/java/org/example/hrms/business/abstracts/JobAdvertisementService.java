package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.JobAdvertisement;
import org.example.hrms.entities.concretes.JobSeeker;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisement> getAll();
    List<JobAdvertisement> findAllByIsActiveTrue();
    List<JobAdvertisement> findAllByIsActiveTrueSortByDate();

    List<JobAdvertisement> findAllByEmployer_Id(int employerId);
    DataResult<JobAdvertisement> findById(int id);
    DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);
}
