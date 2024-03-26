package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

import java.util.List;

public interface EmployerService {

    void signUp(Employer employer) throws Exception;
    DataResult<List<Employer>> getAll();
    DataResult<Employer> add(Employer employer);

}
