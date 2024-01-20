package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.JobAdvertisementDtoService;
import org.example.hrms.business.abstracts.JobAdvertisementService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.dataAccess.abstracts.JobAdvertisementDao;
import org.example.hrms.dtos.JobAdvertisementDto;
import org.example.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/job-advertisements")
@RestController
public class JobAdvertisementController {
    private JobAdvertisementDtoService jobAdvertisementDtoService;
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementDtoService jobAdvertisementDtoService, JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementDtoService = jobAdvertisementDtoService;
        this.jobAdvertisementService = jobAdvertisementService;
    }



    @GetMapping("/getAll")
    DataResult<List<JobAdvertisementDto>> getAll(){
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.findAllByIsActiveTrue();
        return this.jobAdvertisementDtoService.getAll(jobAdvertisements);
    }
    @GetMapping("/getAllSortByDate")
    DataResult<List<JobAdvertisementDto>> getAllSortByDate(){
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.findAllByIsActiveTrueSortByDate();
        return this.jobAdvertisementDtoService.getAll(jobAdvertisements);
    }

    @GetMapping("/getAllByCompanyName")
    DataResult<List<JobAdvertisementDto>> getAllByCompanyName(@PathVariable int employerId){
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.findAllByIsActiveTrueAndEmployer_Id(employerId);
        return this.jobAdvertisementDtoService.getAll(jobAdvertisements);
    }






}
