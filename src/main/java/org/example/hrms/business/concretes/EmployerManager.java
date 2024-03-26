package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.EmployerService;
import org.example.hrms.business.abstracts.UserCheckService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.ErrorDataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.EmployerDao;
import org.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;



@Service
public class EmployerManager implements EmployerService {
    private static final Logger log = LoggerFactory.getLogger(EmployerManager.class);
    private EmployerDao employerDao;
    private UserCheckService userCheckService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserCheckService userCheckService) {
        this.employerDao = employerDao;
        this.userCheckService = userCheckService;

    }


    @Override
    public void signUp(Employer employer) throws Exception {
        if(this.userCheckService.isSignUp(employer)){

        }

    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>("Data listelendi",this.employerDao.findAll());
    }
    @Override
    public DataResult<Employer> add(Employer employer) {
        try {
            this.employerDao.save(employer);
            return new SuccessDataResult<>("İş arayan başarıyla eklendi", employer);
        } catch (DataIntegrityViolationException ex) {
            log.error("Veritabanı hatası:", ex);
            return new ErrorDataResult<>("Veritabanı hatası oluştu", null);
        } catch (Exception ex) {
            log.error("Beklenmeyen bir hata oluştu:", ex);
            return new ErrorDataResult<>("İş arayan eklenirken bir hata oluştu", null);
        }
    }

}
