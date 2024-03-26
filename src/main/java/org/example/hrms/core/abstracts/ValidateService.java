package org.example.hrms.core.abstracts;

import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

import java.util.List;

public interface ValidateService {
    boolean validateUserFields(JobSeeker jobSeeker);
    boolean validateUserFields(Employer employer);
}
