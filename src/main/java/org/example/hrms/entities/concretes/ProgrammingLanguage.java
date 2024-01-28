package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "programming_languages")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ProgrammingLanguage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_name")
    private String languageName;

    @ManyToOne
    @JoinColumn(name = "fk_cv_id")
    private Cv cv;


}
