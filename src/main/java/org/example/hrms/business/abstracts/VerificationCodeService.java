package org.example.hrms.business.abstracts;

import org.example.hrms.entities.concretes.User;
import org.example.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
     void createVerificationCode(User user);

}
