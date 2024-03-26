package org.example.hrms.business.abstracts;

import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
import org.example.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
     void createVerificationCode(JobSeeker jobSeeker);
     void createVerificationCode(Employer employer);

}
