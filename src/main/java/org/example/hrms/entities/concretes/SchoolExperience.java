package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "school_experiences")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SchoolExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_school_id")
    private List<SchoolName> schoolName;

    @Column(name = "major")
    private String major;

    @Column(name = "start_year", nullable = false)
    private Date startYear;

    @Column(name = "end_year" )
    private Date endYear;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    public boolean isCurrentlyGraduate() {
        return endYear == null;
    }
}
