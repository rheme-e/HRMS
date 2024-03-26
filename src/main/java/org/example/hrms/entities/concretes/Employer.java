package org.example.hrms.entities.concretes;



import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "employers")
@Entity
@Data
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "website",nullable = false)
    private String website;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

}

