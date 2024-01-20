package org.example.hrms.business.abstracts;

import org.example.hrms.entities.concretes.User;

public interface UserService<T>{
    void signUp(T entity,String type) throws Exception;
}
