package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.CvService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.SuccessDataResult;
import org.example.hrms.entities.concretes.Cv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/cv")
@RestController
@CrossOrigin
public class CvController {
    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public DataResult<Cv> add(@Valid @RequestBody Cv cv) {
        return this.cvService.add(cv);
    }

    @GetMapping("/getAll")
    public DataResult<List<Cv>> get() {
        return this.cvService.get();
    }
}
