package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.SystemPersonnelService;
import org.example.hrms.dataAccess.abstracts.SystemPersonnelDao;
import org.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {
    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
        this.systemPersonnelDao = systemPersonnelDao;
    }


    //ToDo Sistem personeli kayıt yapmıyor mu?


    @Override
    public void signUp(User entity, String type) throws Exception {

    }
}
