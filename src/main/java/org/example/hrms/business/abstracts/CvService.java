package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.Cv;

import java.util.List;

public interface CvService {
    DataResult<Cv> add(Cv cv);
    public DataResult<List<Cv>> get();


}
