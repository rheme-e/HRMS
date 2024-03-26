package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    void checkPositionName(JobPosition jobPosition);
    DataResult<List<JobPosition>> getAll();
    DataResult<JobPosition> add(JobPosition jobPosition);

}
