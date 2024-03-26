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
    public boolean validateUserFields(JobSeeker jobSeeker){
        List<String> errors = new ArrayList<>();

        if(jobSeeker == null){
            errors.add(getErrorMessage("emptyUser"));
            return handleErrors(errors);
        }
        validateSpecificFields(jobSeeker, errors);

        return handleErrors(errors);
    }
    @Override
    public boolean validateUserFields(Employer employer){
        List<String> errors = new ArrayList<>();

        if(employer == null){
            errors.add(getErrorMessage("emptyUser"));
            return handleErrors(errors);
        }
        validateSpecificFields(employer, errors);

        return handleErrors(errors);
    }

    private void validateSpecificFields(JobSeeker jobSeeker, List<String> errors) {
            if (jobSeeker.getName().isEmpty() || jobSeeker.getName() == null) {
                errors.add(getErrorMessage("emptyName"));
            }
            if (jobSeeker.getLastName().isEmpty()) {
                errors.add(getErrorMessage("emptyLastName"));
            }
            if (jobSeeker.getTcNo().isEmpty()) {
                errors.add(getErrorMessage("emptyIdNo"));
            }
            if (jobSeeker.getBirthDayYear() == 0) {
                errors.add(getErrorMessage("emptyBirthDayYear"));
            }

    }
    private void validateSpecificFields(Employer employer, List<String> errors) {
        if (employer.getCompanyName().isEmpty()) {
            errors.add(getErrorMessage("emptyCompanyName"));
        }
        if (employer.getWebsite().isEmpty()) {
            errors.add(getErrorMessage("emptyWebsite"));
        }
        if (employer.getPhone().isEmpty()) {
            errors.add(getErrorMessage("emptyPhone"));
        }

    }



    private String getErrorMessage(String errorCode){
        return "Error :" + errorCode;
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
