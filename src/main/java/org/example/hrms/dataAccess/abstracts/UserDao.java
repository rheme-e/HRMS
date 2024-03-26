package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.SystemPersonnel;
import org.example.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
