package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.CvService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.CvDao;
import org.example.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public DataResult<Cv> add(Cv cv) {
        return new SuccessDataResult<>("Cv eklendi",cvDao.save(cv));
    }

    @Override
    public DataResult<List<Cv>> get() {
        return new SuccessDataResult<>("Cv listelendi",cvDao.findAll());
    }
}
