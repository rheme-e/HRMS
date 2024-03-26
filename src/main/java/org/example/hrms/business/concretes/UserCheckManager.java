package org.example.hrms.business.concretes;

import org.example.hrms.Helper.Message;
import org.example.hrms.business.abstracts.UserCheckService;
import org.example.hrms.business.abstracts.VerificationCodeService;
import org.example.hrms.core.abstracts.EmailService;
import org.example.hrms.core.abstracts.ValidateService;
import org.example.hrms.dataAccess.abstracts.JobSeekerDao;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
import org.example.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCheckManager implements UserCheckService {
    //ToDo private final JobSeekerDao .. mu olmalı??
    private JobSeekerDao jobSeekerDao;
    private ValidateService validateService;
    private EmailService emailService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public UserCheckManager(JobSeekerDao jobSeekerDao, ValidateService validateService, EmailService emailService ,VerificationCodeService verificationCodeService) {
        this.jobSeekerDao = jobSeekerDao;
        this.validateService = validateService;
        this.emailService = emailService;
        this.verificationCodeService = verificationCodeService;
    }


    public boolean isSignUp(JobSeeker jobSeeker) throws Exception {
        if (!validateService.validateUserFields(jobSeeker)) {
            return false;
        }
        return signUpForJobSeeker(jobSeeker);
    }
    public boolean isSignUp(Employer employer) throws Exception {
        if (!validateService.validateUserFields(employer)) {
            return false;
        }
        return signUpForEmployer(employer);
    }

    private boolean signUpForJobSeeker(JobSeeker jobSeeker) throws Exception {
        if (checkIfRealPerson(jobSeeker) && checkIfNewEmail(jobSeeker) && checkIfNewTcNo(jobSeeker)) {
            verificationCodeService.createVerificationCode(jobSeeker);
            return true;
        }

        return false;
    }

    private boolean signUpForEmployer(Employer employer) throws Exception {
        if (checkIfNewEmail(employer)  && sendVerificationHrmsAndHandleResult(employer)) {
            verificationCodeService.createVerificationCode(employer);
            Message.showMessage("success");
            return true;
        }

        return false;
    }

    private boolean sendVerificationEmailAndHandleResult(JobSeeker jobSeeker, String verificationLink) {
        emailService.sendVerificationEmail(jobSeeker, verificationLink);
        return emailService.checkActivation();
    }
    private boolean sendVerificationEmailAndHandleResult(Employer employer, String verificationLink) {
        emailService.sendVerificationEmail(employer, verificationLink);
        return emailService.checkActivation();
    }

    private boolean sendVerificationHrmsAndHandleResult(Employer employer) {
        emailService.sendVerificationHrms();
        return emailService.HrmsApproval();
    }


    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
        boolean isValid = org.example.hrms.business.abstracts.UserCheckService.super.checkIfRealPerson(jobSeeker);
        System.out.println("Mernis doğrulaması " + (isValid ? "başarılı" : "başarısız"));
        return isValid;
    }

    //ToDo içeriği doldur!
    @Override
    public boolean checkIfNewEmail(JobSeeker jobSeeker) {
        boolean isNewEmail = org.example.hrms.business.abstracts.UserCheckService.super.checkIfNewEmail(jobSeeker);
        if (!isNewEmail) {
            System.out.println("Bu email ile kayıt yapılmıştır!");
        }
        return isNewEmail;
    }
    @Override
    public boolean checkIfNewEmail(Employer employer) {
        boolean isNewEmail = org.example.hrms.business.abstracts.UserCheckService.super.checkIfNewEmail(employer);
        if (!isNewEmail) {
            System.out.println("Bu email ile kayıt yapılmıştır!");
        }
        return isNewEmail;
    }

    //ToDo içeriği doldur!
    @Override
    public boolean checkIfNewTcNo(JobSeeker jobSeeker) {
        boolean isNewTcNo = org.example.hrms.business.abstracts.UserCheckService.super.checkIfNewTcNo(jobSeeker);
        if (!isNewTcNo) {
            System.out.println("Bu tcNo ile kayıt yapılmıştır!");
        }
        return isNewTcNo;
    }

    //ToDo içeriği doldur!
    @Override
    public boolean checkIsEmailMatchingDomain(Employer employer) {

        return true;
    }
}
