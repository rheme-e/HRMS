package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvDao extends JpaRepository<Cv, Integer> {
}
