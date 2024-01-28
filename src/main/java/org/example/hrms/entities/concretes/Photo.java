package org.example.hrms.entities.concretes;

import lombok.Data;
import org.example.hrms.business.abstracts.PhotoService;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Data
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @OneToOne
    @JoinColumn(name = "fk_cv_id" , nullable = false)
    private Cv cv;

    public void uploadPhoto(MultipartFile file, PhotoService photoService) throws IOException {
        this.url = photoService.uploadPhoto(file);
    }
}
