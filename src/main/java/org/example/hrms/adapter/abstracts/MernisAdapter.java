package org.example.hrms.adapter.abstracts;

import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;

public interface MernisAdapter {
    default boolean checkIfRealPerson(User user) throws Exception {
        return true;
    }


}
