package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Table(name = "verification_codes")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "code" , unique = true)
    private String code;


    @ManyToOne
    @JoinColumn(name = "fk_job_seeker_id")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "fk_employer_id")
    private Employer employer;


    public VerificationCode(String code, JobSeeker jobSeeker) {
        this.code = code;
        this.jobSeeker = jobSeeker;
    }
    public VerificationCode(String code, Employer employer) {
        this.code = code;
        this.employer = employer;
    }

}
