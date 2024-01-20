package org.example.hrms.business.concretes;

import org.example.hrms.business.abstracts.JobAdvertisementDtoService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import org.example.hrms.dtos.JobAdvertisementDto;
import org.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdvertisementDtoManager implements JobAdvertisementDtoService {


    @Override
    public DataResult<List<JobAdvertisementDto>> getAll(List<JobAdvertisement> jobAdvertisements) {
        List<JobAdvertisementDto> jobAdvertisementDtoList = new ArrayList<>();
        for(JobAdvertisement j : jobAdvertisements){
            JobAdvertisementDto jobAdvertisementDto = new JobAdvertisementDto();
            jobAdvertisementDto.setCompanyName(j.getEmployer().getCompanyName());
            jobAdvertisementDto.setJobPositionName(j.getJobPosition().getPositionName());
            jobAdvertisementDto.setOpenPosition(j.getOpenPosition());
            jobAdvertisementDto.setReleaseDate(j.getReleaseDate());
            jobAdvertisementDto.setApplicationDeadline(j.getApplicationDeadline());
            jobAdvertisementDtoList.add(jobAdvertisementDto);
        }
       return new SuccessDataResult<List<JobAdvertisementDto>>("İş ilanı DTO'ya eklendi.",jobAdvertisementDtoList);
    }


}
