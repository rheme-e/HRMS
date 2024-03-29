package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_company_id")
    private List<CompanyName> companyNames;

    @Column(name = "position")
    private String position;

    @Column(name = "start_year" , nullable = false)
    private Date startYear;

    @Column(name = "end_year" , nullable = true)
    private Date endYear;

    @ManyToOne
    @JoinColumn(name = "fk_cv_id") //git
    private Cv cv;

    public boolean isCurrentlyEmployed() {
        return endYear == null;
    }
}
