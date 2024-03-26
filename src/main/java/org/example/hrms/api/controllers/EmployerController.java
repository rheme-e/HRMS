package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.EmployerService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.core.utilities.result.ErrorDataResult;
import org.example.hrms.entities.concretes.Employer;
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
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
        try {
            User user = new User();
            user.setEmail(employer.getUser().getEmail());
            user.setPassword(employer.getUser().getPassword());

            employer.setUser(user);
            DataResult<Employer> result = employerService.add(employer);

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
