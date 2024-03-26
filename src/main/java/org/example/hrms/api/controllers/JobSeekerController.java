package org.example.hrms.api.controllers;


import org.example.hrms.business.abstracts.JobSeekerService;
import org.example.hrms.core.utilities.result.*;
import org.example.hrms.entities.concretes.JobSeeker;
import org.example.hrms.entities.concretes.User;
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

@RequestMapping("/api/job-seekers")
@RestController
@CrossOrigin
public class JobSeekerController {
    private JobSeekerService jobSeekerService;
    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {

        this.jobSeekerService = jobSeekerService;

    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll(){
        return this.jobSeekerService.getAll();
    }


    @GetMapping("/get-job-seeker/{id}")
    public DataResult<JobSeeker> getById(@PathVariable int id){
        return this.jobSeekerService.findById(id);
    }

    @GetMapping("/get-job-seeker-by-user-id/{userId}")
    public DataResult<JobSeeker> getByUserId(@PathVariable int userId){
        return this.jobSeekerService.findByUserId(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
        try {
            User user = new User();
            user.setEmail(jobSeeker.getUser().getEmail());
            user.setPassword(jobSeeker.getUser().getPassword());

            jobSeeker.setUser(user);

            DataResult<JobSeeker> result = jobSeekerService.add(jobSeeker);

            if (result.isSuccess()) {
                return ResponseEntity.ok(result.getMessage());
            } else {
                return ResponseEntity.badRequest().body(result.getMessage());
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody JobSeeker jobSeeker) {
        try {
            User user = new User();
            user.setEmail(jobSeeker.getUser().getEmail());
            user.setPassword(jobSeeker.getUser().getPassword());

            jobSeeker.setUser(user);

            DataResult<JobSeeker> result = jobSeekerService.signUp(jobSeeker);

            if (result.isSuccess()) {
                return ResponseEntity.ok(result.getMessage());
            } else {
                return ResponseEntity.badRequest().body(result.getMessage());
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
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
