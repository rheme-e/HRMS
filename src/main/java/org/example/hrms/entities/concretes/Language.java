package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "languages")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Language {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "rate")
    private int rate;

    @ManyToOne
    @JoinColumn(name = "fk_cv_id")
    private Cv cv;

    public void setRate(int rate) {
        if (rate < 1 || rate > 5) {
            throw new IllegalArgumentException("Rate must be between 1 and 5.");
        }
        this.rate = rate;
    }

}
