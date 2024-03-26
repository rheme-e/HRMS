package org.example.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    @Email
    @NotBlank
    @NotNull
    @Column(name = "email" , unique = true , nullable = false)
    private  String email;


    @NotBlank
    @NotNull
    @Column(name = "password" , nullable = false)
    private String password;


}
