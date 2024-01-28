package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.SchoolExperience;

import java.util.List;

public interface SchoolExperienceService {
    DataResult<List<SchoolExperience>> getAll();
}
