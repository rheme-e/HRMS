package org.example.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
@Data
@Entity
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_job_position_id", nullable = false)
    private JobPosition jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "open_position", nullable = false)
    private int openPosition;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "model")
    private String model;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;



}