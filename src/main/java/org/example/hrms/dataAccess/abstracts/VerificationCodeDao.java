package org.example.hrms.dataAccess.abstracts;

import org.example.hrms.entities.concretes.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeDao extends JpaRepository<VerificationCode,Integer> {


}
