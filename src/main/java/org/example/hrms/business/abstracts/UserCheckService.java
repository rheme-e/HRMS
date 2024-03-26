package org.example.hrms.business.abstracts;

import org.example.hrms.adapter.abstracts.MernisAdapter;
import org.example.hrms.entities.concretes.Employer;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

public interface UserCheckService extends MernisAdapter {
    @Override
    default boolean checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
        return MernisAdapter.super.checkIfRealPerson(jobSeeker);
    }

    default boolean isSignUp(JobSeeker jobSeeker) throws Exception {
        return true;
    }
    default boolean isSignUp(Employer employer) throws Exception {
        return true;
    }

    default boolean checkIfNewEmail( JobSeeker jobSeeker) {
        return true;
    }
    default boolean checkIfNewEmail( Employer employer) {
        return true;
    }

    default boolean checkIfNewTcNo(JobSeeker jobSeeker ) {
        return true;
    }

    default boolean checkIsEmailMatchingDomain(Employer employer) {
        return false;
    }

}
