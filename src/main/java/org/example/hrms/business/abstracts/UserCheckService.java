package org.example.hrms.business.abstracts;

import org.example.hrms.adapter.abstracts.MernisAdapter;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

public interface UserCheckService extends MernisAdapter {
    @Override
    default boolean checkIfRealPerson(User user) throws Exception {
        return MernisAdapter.super.checkIfRealPerson(user);
    }

    default boolean isSignUp(User user, String type) throws Exception {
        return true;
    }
    default boolean checkIfNewEmail(User user) {
        return true;
    }
    default boolean checkIfNewTcNo(User user) {
        return true;
    }

    default boolean checkIsEmailMatchingDomain(Employer employer) {
        return false;
    }

}
