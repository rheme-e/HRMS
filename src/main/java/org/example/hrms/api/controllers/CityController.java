package org.example.hrms.api.controllers;

import org.example.hrms.business.concretes.CityManager;
import org.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {

    private final CityManager cityManager;


    @Autowired
    public CityController(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @GetMapping("/all")
    public List<City> getAllCities() {
        return cityManager.getAllCities();
    }
}
