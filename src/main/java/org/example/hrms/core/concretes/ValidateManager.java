package org.example.hrms.core.concretes;

import org.example.hrms.Helper.Message;
import org.example.hrms.core.abstracts.ValidateService;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ValidateManager implements ValidateService {


    @Override
    public boolean validateUserFields(Object user, String userType){
        List<String> errors = new ArrayList<>();

        if(user == null){
            errors.add(getErrorMessage("emptyUser",userType));
            return handleErrors(errors);
        }
        validateSpecificFields(user, errors);

        return handleErrors(errors);
    }

    private void validateSpecificFields(Object user, List<String> errors) {

        if (user instanceof JobSeeker) {
            JobSeeker jobSeeker = (JobSeeker) user;
            if (jobSeeker.getName().isEmpty() || jobSeeker.getName() == null) {
                errors.add(getErrorMessage("emptyName", "jobseeker"));
            }
            if (jobSeeker.getLastName().isEmpty()) {
                errors.add(getErrorMessage("emptyLastName", "jobseeker"));
            }
            if (jobSeeker.getTcNo().isEmpty()) {
                errors.add(getErrorMessage("emptyIdNo", "jobseeker"));
            }
            if (jobSeeker.getBirthDayYear() == 0) {
                errors.add(getErrorMessage("emptyBirthDayYear", "jobseeker"));
            }

            //if (jobSeeker.getEmail().isEmpty()) {
             //   errors.add(getErrorMessage("emptyEmail", "jobseeker"));
           // }
            //if (jobSeeker.getPassword().isEmpty()) {
             //   errors.add(getErrorMessage("emptyPassword", "jobseeker"));
           // }



        } else if (user instanceof Employer) {
            Employer employer = (Employer) user;
            if (employer.getCompanyName().isEmpty()) {
                errors.add(getErrorMessage("emptyCompanyName", "employer"));
            }
            if (employer.getWebsite().isEmpty()) {
                errors.add(getErrorMessage("emptyWebsite", "employer"));
            }
            if (employer.getPhone().isEmpty()) {
                errors.add(getErrorMessage("emptyPhone", "employer"));
            }
//            if (employer.getEmail().isEmpty()) {
//                errors.add(getErrorMessage("emptyEmail", "employer"));
//            }
//            if (employer.getPassword().isEmpty()) {
//                errors.add(getErrorMessage("emptyPassword", "employer"));
//            }

        }


    }


    private String getErrorMessage(String errorCode, String userType){
        return "Error (" + userType + "): " + errorCode;
    }

    private boolean handleErrors(List<String> errors) {
        if (!errors.isEmpty()) {
            for (String error : errors) {
                Message.showMessage(error);
            }
            return false;
        }
        return true;
    }
}
