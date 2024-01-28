package org.example.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements org.example.hrms.entities.abstracts.User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "email" , unique = true , nullable = false)
    private  String email;

    @Column(name = "password" , nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private JobSeeker jobSeeker;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employer employer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private SystemPersonnel systemPersonnel;

    @ManyToOne
    @JoinColumn ( name = "fk_user_id")
    private JobPosition jobPosition;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<VerificationCode> verificationCode;


}
