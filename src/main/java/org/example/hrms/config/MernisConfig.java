package org.example.hrms.config;

import org.example.hrms.mernisReferance.DAVKPSPublicSoap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MernisConfig {

    @Bean
    public DAVKPSPublicSoap davkpsPublicSoap() {
        return new DAVKPSPublicSoap();
    }
}
