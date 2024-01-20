package org.example.hrms.core.concretes;

import org.example.hrms.business.abstracts.VerificationCodeService;
import org.example.hrms.config.AppConfig;
import org.example.hrms.core.abstracts.EmailService;
import org.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;



@Service
public class EmailManager implements EmailService<User> {

    private AppConfig appConfig;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public EmailManager(AppConfig appConfig,VerificationCodeService verificationCodeService) {
        this.appConfig = appConfig;
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public void sendVerificationEmail(User user, String verificationLink) {
        String to = user.getEmail();
        String subject = "Hesap Doğrulama";
        String body = "Lütfen aşağıdaki bağlantıya tıklayarak hesabınızı doğrulayın:\n" + verificationLink;
        sendEmail(to, subject, body);
        verificationCodeService.createVerificationCode(user);

    }

    @Override
    public boolean checkActivation() {

        return true;
    }

    @Override
    public void sendVerificationHrms() {

    }

    @Override
    public boolean HrmsApproval() {
        return true;
    }

    private void sendEmail(String to, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(appConfig.getEmailUsername(), appConfig.getEmailPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(appConfig.getEmailUsername()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("E-posta gönderildi!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("E-posta gönderme hatası: " + e.getMessage());
        }
    }
}

