package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> findAllByIsActiveTrue();
    List<JobAdvertisement> findAllByIsActiveTrue(Sort sort);

    List<JobAdvertisement> findAllByIsActiveTrueAndEmployer_Id(int employerId);



}
