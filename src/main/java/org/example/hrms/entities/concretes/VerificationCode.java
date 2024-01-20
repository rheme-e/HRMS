package org.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "verification_codes")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;

    @JoinColumn(name = "code")
    private String code;

    @ManyToOne
    @JoinColumn ( name = "fk_user_id")
    private User user;


    public VerificationCode(String refCode, User user) {
    }
}
