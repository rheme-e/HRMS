package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.VerificationCodeService;
import org.example.hrms.dataAccess.abstracts.VerificationCodeDao;
import org.example.hrms.entities.concretes.User;
import org.example.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class VerificationCodeManager implements VerificationCodeService {
    private VerificationCodeDao verificationCodeDao;

    @Autowired
    public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }

    @Override
    public void createVerificationCode(User user) {
        String refCode = UUID.randomUUID().toString();
        VerificationCode verificationCode = new VerificationCode(refCode,user);
        System.out.println("Doğrulama kodu:"+verificationCode);
        verificationCodeDao.save(verificationCode);

    }
}
