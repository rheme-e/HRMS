package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.EmployerService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/employers")
@RestController
public class EmployerController {
    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/all")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }
}
