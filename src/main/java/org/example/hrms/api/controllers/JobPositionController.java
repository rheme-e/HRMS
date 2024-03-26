package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.JobPositionService;
import org.example.hrms.core.utilities.result.*;
import org.example.hrms.entities.concretes.JobPosition;
import org.example.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/job-positions")
@RestController
@CrossOrigin
public class JobPositionController {
    private final JobPositionService jobPositionService;
    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


//    @PostMapping("/add")
//    public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition) {
//        try {
//
//            DataResult<JobPosition> result = jobPositionService.add(jobPosition);
//
//            if (result.isSuccess()) {
//                return ResponseEntity.ok(result.getMessage());
//            } else {
//                return ResponseEntity.badRequest().body(result.getMessage());
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
//        }
//    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }
    @PostMapping("/add")
    public DataResult<JobPosition> add(@Valid @RequestBody JobPosition jobPosition) {
        jobPositionService.add(jobPosition);
        return new SuccessDataResult<>("İş pozisyonu eklendi",jobPosition);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationsErrors = new HashMap<String,String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationsErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>("Doğrulama Hataları",validationsErrors);
        return errors;
    }

}
