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
            jobAdvertisementDto.setId(j.getId());
            jobAdvertisementDto.setCompanyName(j.getEmployer().getCompanyName());
            jobAdvertisementDto.setJobPositionName(j.getJobPosition().getPositionName());
            jobAdvertisementDto.setOpenPosition(j.getOpenPosition());
            jobAdvertisementDto.setReleaseDate(j.getReleaseDate());
            jobAdvertisementDto.setApplicationDeadline(j.getApplicationDeadline());
            jobAdvertisementDto.setModel(j.getModel());
            jobAdvertisementDto.setTime(j.getTime());
            jobAdvertisementDto.setCity(j.getCity().getName());
            jobAdvertisementDto.setActive(j.isActive());
            jobAdvertisementDtoList.add(jobAdvertisementDto);
            jobAdvertisementDto.setJobDescription(j.getJobDescription());
        }
       return new SuccessDataResult<List<JobAdvertisementDto>>("İş ilanı DTO'ya eklendi.",jobAdvertisementDtoList);
    }

    @Override
    public DataResult<JobAdvertisementDto> get(JobAdvertisement jobAdvertisement) {
        JobAdvertisementDto jobAdvertisementDto = new JobAdvertisementDto();
        jobAdvertisementDto.setId(jobAdvertisement.getId());
        jobAdvertisementDto.setCompanyName(jobAdvertisement.getEmployer().getCompanyName());
        jobAdvertisementDto.setJobPositionName(jobAdvertisement.getJobPosition().getPositionName());
        jobAdvertisementDto.setOpenPosition(jobAdvertisement.getOpenPosition());
        jobAdvertisementDto.setReleaseDate(jobAdvertisement.getReleaseDate());
        jobAdvertisementDto.setApplicationDeadline(jobAdvertisement.getApplicationDeadline());
        jobAdvertisementDto.setModel(jobAdvertisement.getModel());
        jobAdvertisementDto.setTime(jobAdvertisement.getTime());
        jobAdvertisementDto.setCity(jobAdvertisement.getCity().getName());
        jobAdvertisementDto.setActive(jobAdvertisement.isActive());
        jobAdvertisementDto.setJobDescription(jobAdvertisement.getJobDescription());

        return new SuccessDataResult<>("ok",jobAdvertisementDto);
    }





}
