package org.example.hrms.adapter.abstracts;

import org.example.hrms.entities.concretes.JobSeeker;


public interface MernisAdapter {
    default boolean checkIfRealPerson(JobSeeker jobSeeker) throws Exception {
        return true;
    }


}
