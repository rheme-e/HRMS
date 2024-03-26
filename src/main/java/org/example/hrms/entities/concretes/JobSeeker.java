package org.example.hrms.entities.concretes;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "job_seekers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "tc_no", unique = true , nullable = false)
    private String tcNo;

    @Column(name = "birth_day_year", nullable = false)
    private int birthDayYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;


}
