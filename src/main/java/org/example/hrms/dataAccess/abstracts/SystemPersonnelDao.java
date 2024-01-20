package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {
}
