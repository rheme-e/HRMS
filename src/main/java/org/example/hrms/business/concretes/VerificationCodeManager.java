package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.VerificationCodeService;
import org.example.hrms.dataAccess.abstracts.EmployerDao;
import org.example.hrms.dataAccess.abstracts.JobSeekerDao;
import org.example.hrms.dataAccess.abstracts.VerificationCodeDao;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
import org.example.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class VerificationCodeManager implements VerificationCodeService {
    private VerificationCodeDao verificationCodeDao;
    private JobSeekerDao jobSeekerDao;
    private EmployerDao employerDao;

    @Autowired
    public VerificationCodeManager(VerificationCodeDao verificationCodeDao,JobSeekerDao jobSeekerDao,EmployerDao employerDao) {
        this.verificationCodeDao = verificationCodeDao;
        this.jobSeekerDao=jobSeekerDao;
        this.employerDao=employerDao;
    }

    @Override
    public void createVerificationCode(JobSeeker jobSeeker) {
        String refCode = UUID.randomUUID().toString();
        VerificationCode verificationCode = new VerificationCode(refCode,jobSeeker);

        // JobSeeker nesnesini al
        JobSeeker savedJobSeeker = jobSeekerDao.save(jobSeeker);

        // VerificationCode nesnesini kaydetmeden önce jobSeeker alanını ayarla
        verificationCode.setJobSeeker(savedJobSeeker);

        // VerificationCode nesnesini kaydet
        verificationCodeDao.save(verificationCode);

        System.out.println("Doğrulama kodu: " + verificationCode);
    }



    @Override
    public void createVerificationCode(Employer employer) {
        String refCode = UUID.randomUUID().toString();
        VerificationCode verificationCode = new VerificationCode(refCode,employer);

        Employer savedEmployer = employerDao.save(employer);

        verificationCode.setEmployer(savedEmployer);

        verificationCodeDao.save(verificationCode);

        System.out.println("Doğrulama kodu: " + verificationCode);
    }


}
