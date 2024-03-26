package org.example.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "position_names")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition implements org.example.hrms.entities.abstracts.JobPosition {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position_name")
    private String positionName;


}
