package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<City,Integer> {
}
