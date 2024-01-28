package org.example.hrms.business.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.example.hrms.business.abstracts.PhotoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class PhotoManager implements PhotoService {

    private final Cloudinary cloudinary;


    public PhotoManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadPhoto(MultipartFile file) throws IOException {
        Map<?, ?> options = ObjectUtils.asMap(
                "transformation", new Transformation().width(300).height(300).crop("fill")
        );

        Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), options);
        return (String) result.get("secure_url");
    }


}
