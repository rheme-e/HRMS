package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvDao extends JpaRepository<Cv, Integer> {
}
