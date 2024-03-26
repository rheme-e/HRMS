package org.example.hrms.core.abstracts;

import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;

public interface EmailService {
    void sendVerificationEmail(JobSeeker jobSeeker, String verificationLink);
    void sendVerificationEmail(Employer employer, String verificationLink);
    boolean checkActivation();
    void sendVerificationHrms();
    boolean HrmsApproval();


}
