package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.SchoolExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolExperienceDao extends JpaRepository<SchoolExperience , Integer> {
}
