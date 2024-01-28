package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "job_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "position")
    private String position;

    @Column(name = "start_year" , nullable = false)
    private Date startYear;

    @Column(name = "end_year" , nullable = true)
    private Date endYear;

    @ManyToOne
    @JoinColumn(name = "fk_cv_id")
    private Cv cv;

    public boolean isCurrentlyEmployed() {
        return endYear == null;
    }
}
