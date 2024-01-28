package org.example.hrms.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "rheme",
                "api_key", "688131156928599",
                "api_secret", "rg6_8dFUj4k76qUGNYz5h5hIz2Q"
        ));
    }
}
