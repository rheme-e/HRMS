package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "school_names")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SchoolName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;


}
