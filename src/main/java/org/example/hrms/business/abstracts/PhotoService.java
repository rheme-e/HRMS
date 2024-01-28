package org.example.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String uploadPhoto(MultipartFile file) throws IOException;
}
