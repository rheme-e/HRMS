package org.example.hrms.core.abstracts;

public interface EmailService <T>{
    void sendVerificationEmail(T entity,String verificationLink);
    boolean checkActivation();
    void sendVerificationHrms();
    boolean HrmsApproval();


}
