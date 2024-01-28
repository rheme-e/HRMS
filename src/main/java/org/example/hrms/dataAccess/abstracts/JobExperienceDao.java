package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience , Integer> {
}
