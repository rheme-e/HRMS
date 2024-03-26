package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.JobSeekerService;
import org.example.hrms.business.abstracts.UserCheckService;
import org.example.hrms.core.utilities.result.*;
import org.example.hrms.dataAccess.abstracts.JobSeekerDao;
import org.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerManager implements JobSeekerService {
    private static final Logger log = LoggerFactory.getLogger(JobSeekerManager.class);

    private JobSeekerDao jobSeekerDao;
    private UserCheckService userCheckService;



    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserCheckService userCheckService) {
        this.jobSeekerDao = jobSeekerDao;
        this.userCheckService=userCheckService;


    }


    @Override
    public DataResult<JobSeeker> signUp(JobSeeker jobSeeker) throws Exception {
        if(this.userCheckService.isSignUp(jobSeeker)){
            jobSeekerDao.save(jobSeeker);
        }
        return new SuccessDataResult<>("İş arayan başarıyla eklendi", jobSeeker);

    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>("Data listelendi",this.jobSeekerDao.findAll());
    }

    @Override
    public DataResult<JobSeeker> findById(int id) {
        Optional<JobSeeker> jobSeekerOptional = jobSeekerDao.findById(id);
        if (jobSeekerOptional.isPresent()) {
            JobSeeker jobSeeker = jobSeekerOptional.get();
            return new SuccessDataResult<>("Kullanıcı listelendi", jobSeeker);
        } else {
            return new ErrorDataResult<>("Kullanıcı bulunamadı", null);
        }
    }

    @Override
    public DataResult<JobSeeker> findByUserId(int userId) {
        Optional<JobSeeker> jobSeekerOptional = jobSeekerDao.findByUserId(userId);
        if (jobSeekerOptional.isPresent()) {
            JobSeeker jobSeeker = jobSeekerOptional.get();
            return new SuccessDataResult<>("Kullanıcı listelendi", jobSeeker);
        } else {
            return new ErrorDataResult<>("Kullanıcı bulunamadı", null);
        }    }

    @Override
    public DataResult<JobSeeker> add(JobSeeker jobSeeker) {
        try {
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessDataResult<>("İş arayan başarıyla eklendi", jobSeeker);
        } catch (DataIntegrityViolationException ex) {
            log.error("Veritabanı hatası:", ex);
            return new ErrorDataResult<>("Veritabanı hatası oluştu", null);
        } catch (Exception ex) {
            log.error("Beklenmeyen bir hata oluştu:", ex);
            return new ErrorDataResult<>("İş arayan eklenirken bir hata oluştu", null);
        }
    }



}
