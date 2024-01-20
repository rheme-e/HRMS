package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.EmployerService;
import org.example.hrms.business.abstracts.UserCheckService;
import org.example.hrms.core.abstracts.EmailService;
import org.example.hrms.core.abstracts.ValidateService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.EmployerDao;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private UserCheckService userCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserCheckService userCheckService) {
        this.employerDao = employerDao;
        this.userCheckService = userCheckService;

    }


    @Override
    public void signUp(User user, String type) throws Exception {
        if(this.userCheckService.isSignUp(user,type)){

        }

    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>("Data listelendi",this.employerDao.findAll());
    }


}
