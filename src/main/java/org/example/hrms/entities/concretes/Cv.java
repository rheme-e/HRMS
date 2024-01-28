package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "cvs")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cv {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cv" , cascade = CascadeType.ALL)
    private List<SchoolExperience> schoolExperience;

    @OneToMany(mappedBy = "cv" , cascade = CascadeType.ALL)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "cv" , cascade = CascadeType.ALL)
    private List<Language> languages;

    @OneToOne(mappedBy = "cv" , cascade = CascadeType.ALL)
    private Photo photo;

    @Column( name = "github_url")
    private String githubUrl;

    @Column( name = "linkedln_url")
    private String linkedlnUrl;

    @OneToMany(mappedBy = "cv" , cascade = CascadeType.ALL)
    private List<ProgrammingLanguage> programmingLanguages;

    @Column( name = "cover_letter")
    private String coverLetter ;


}
