package org.example.hrms.config;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class AppConfig {

    private String emailUsername;
    private String emailPassword;

    public AppConfig() {
        loadConfig();
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    private void loadConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            Properties prop = new Properties();
            prop.load(input);

            setEmailUsername(prop.getProperty("email.username"));
            setEmailPassword(prop.getProperty("email.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
