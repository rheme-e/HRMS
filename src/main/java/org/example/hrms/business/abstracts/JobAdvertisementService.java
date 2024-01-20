package org.example.hrms.business.abstracts;

import org.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobAdvertisementService {
    List<JobAdvertisement> findAllByIsActiveTrue();
    List<JobAdvertisement> findAllByIsActiveTrueSortByDate();

    List<JobAdvertisement> findAllByIsActiveTrueAndEmployer_Id(int employerId);
}
