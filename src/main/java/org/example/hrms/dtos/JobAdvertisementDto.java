package org.example.hrms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementDto {
        private int id;
        private String companyName;
        private String jobPositionName;
        private int openPosition;
        private Date releaseDate;
        private Date applicationDeadline;
        private String model;
        private String time;
        private String city;
        private boolean isActive;
        private String jobDescription;

}
