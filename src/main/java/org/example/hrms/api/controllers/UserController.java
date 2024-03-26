package org.example.hrms.api.controllers;

import org.example.hrms.business.abstracts.UserService;
import org.example.hrms.core.utilities.result.DataResult;
import org.example.hrms.entities.concretes.JobPosition;
import org.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/users")
@RestController
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }
}
