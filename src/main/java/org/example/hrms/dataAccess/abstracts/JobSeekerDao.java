package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    @Query("SELECT j FROM JobSeeker j WHERE j.user.id = :userId")
    Optional<JobSeeker> findByUserId(int userId);
}
