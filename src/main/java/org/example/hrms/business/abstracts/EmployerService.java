package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.User;

import java.util.List;

public interface EmployerService extends UserService<User> {
    @Override
    void signUp(User user,String type) throws Exception;
    DataResult<List<Employer>> getAll();
}
