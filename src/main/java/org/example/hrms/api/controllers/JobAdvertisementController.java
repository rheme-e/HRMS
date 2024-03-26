package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.JobAdvertisementDtoService;
import org.example.hrms.business.abstracts.JobAdvertisementService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.ErrorDataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.dtos.JobAdvertisementDto;
import org.example.hrms.entities.concretes.JobAdvertisement;
import org.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/job-advertisements")
@RestController
@CrossOrigin
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
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.getAll();
        return this.jobAdvertisementDtoService.getAll(jobAdvertisements);
    }
    @GetMapping("/getAllSortByDate")
    DataResult<List<JobAdvertisementDto>> getAllSortByDate(){
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.findAllByIsActiveTrueSortByDate();
        return this.jobAdvertisementDtoService.getAll(jobAdvertisements);
    }

    @GetMapping("/getAllByEmployerId/{employerId}")
    DataResult<List<JobAdvertisementDto>> getAllByEmployerId(@PathVariable int employerId){
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementService.findAllByEmployer_Id(employerId);
        return this.jobAdvertisementDtoService.getAll(jobAdvertisements);
    }
    @GetMapping("/getById/{id}")
    public DataResult<JobAdvertisementDto> getById(@PathVariable int id){
        return this.jobAdvertisementDtoService.get(jobAdvertisementService.findById(id).getData());
    }

    @PostMapping("/add")
    public DataResult<JobAdvertisement> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
        jobAdvertisementService.add(jobAdvertisement);
        return new SuccessDataResult<>("İş ilanı eklendi",jobAdvertisement);
    }






}