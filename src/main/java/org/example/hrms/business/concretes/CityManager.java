package org.example.hrms.business.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.List;
import java.util.Arrays;

@Service
public class CityManager {

    public List<City> getAllCities() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CityList cityList = objectMapper.readValue(new File("/Users/esragonul/IdeaProjects/HRMS/HRMS/src/main/resources/city-data/il-ilce.json"), CityList.class);
            return Arrays.asList(cityList.getCities());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Nested class to represent JSON structure
    private static class CityList {
        private City[] cities;

        public City[] getCities() {
            return cities;
        }

        public void setCities(City[] cities) {
            this.cities = cities;
        }
    }
}
