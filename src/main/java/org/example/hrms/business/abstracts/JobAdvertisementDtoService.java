package org.example.hrms.business.abstracts;

import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.dtos.JobAdvertisementDto;
import org.example.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementDtoService {
    DataResult<List<JobAdvertisementDto>> getAll(List<JobAdvertisement> jobAdvertisements);

    DataResult<JobAdvertisementDto> get(JobAdvertisement jobAdvertisements);


}
