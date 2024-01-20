package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.JobPositionService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/job-positions")
@RestController
public class JobPositionController {
    private final JobPositionService jobPositionService;
    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }
    @GetMapping("/all")
    public DataResult<List<JobPosition>> getALL() {
        return this.jobPositionService.getALL();
    }

}
