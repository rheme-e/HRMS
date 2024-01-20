package org.example.hrms.business.concretes;

import org.example.hrms.Helper.Message;
import org.example.hrms.business.abstracts.UserCheckService;
import org.example.hrms.business.abstracts.VerificationCodeService;
import org.example.hrms.core.abstracts.EmailService;
import org.example.hrms.core.abstracts.ValidateService;
import org.example.hrms.dataAccess.abstracts.JobSeekerDao;
import org.example.hrms.entities.concretes.Employer;
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

    @Autowired
    public UserCheckManager(JobSeekerDao jobSeekerDao, ValidateService validateService, EmailService emailService ) {
        this.jobSeekerDao = jobSeekerDao;
        this.validateService = validateService;
        this.emailService = emailService;
    }


    public boolean isSignUp(User user, String type) throws Exception {
        if (!validateService.validateUserFields(user, type)) {
            return false;
        }
        if (type.equals("jobseeker")) {
            return signUpForJobSeeker(user);
        } else if (type.equals("employer")) {
            return signUpForEmployer(user);
        }

        return false;
    }

    private boolean signUpForJobSeeker(User user) throws Exception {
        if (checkIfRealPerson(user) && checkIfNewEmail(user) && checkIfNewTcNo(user)) {
            sendVerificationEmailAndHandleResult(user, "verificationLink");
            return true;
        }

        return false;
    }

    private boolean signUpForEmployer(User user) throws Exception {
        if (checkIfNewEmail(user) && checkIfNewEmail(user) && sendVerificationEmailAndHandleResult(user, "verificationLink") && sendVerificationHrmsAndHandleResult(user)) {
            Message.showMessage("success");
            return true;
        }

        return false;
    }

    private boolean sendVerificationEmailAndHandleResult(User user, String verificationLink) {
        emailService.sendVerificationEmail(user, verificationLink);
        return emailService.checkActivation();
    }

    private boolean sendVerificationHrmsAndHandleResult(User user) {
        emailService.sendVerificationHrms();
        return emailService.HrmsApproval();
    }


    @Override
    public boolean checkIfRealPerson(User user) throws Exception {
        boolean isValid = org.example.hrms.business.abstracts.UserCheckService.super.checkIfRealPerson(user);
        System.out.println("Mernis doğrulaması " + (isValid ? "başarılı" : "başarısız"));
        return isValid;
    }

    //ToDo içeriği doldur!
    @Override
    public boolean checkIfNewEmail(User user) {
        boolean isNewEmail = org.example.hrms.business.abstracts.UserCheckService.super.checkIfNewEmail(user);
        if (!isNewEmail) {
            System.out.println("Bu email ile kayıt yapılmıştır!");
        }
        return isNewEmail;
    }

    //ToDo içeriği doldur!
    @Override
    public boolean checkIfNewTcNo(User user) {
        boolean isNewTcNo = org.example.hrms.business.abstracts.UserCheckService.super.checkIfNewTcNo(user);
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
