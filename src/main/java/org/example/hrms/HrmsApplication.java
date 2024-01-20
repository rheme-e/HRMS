package org.example.hrms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hrms.entities.concretes.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
		runCitiesJson();

	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.example.hrms"))
				.build();
	}

	public static void runCitiesJson(){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			File file = new File("src/main/resources/city-data/il-ilce.json");
			JsonNode jsonNode = objectMapper.readTree(file);

			if (jsonNode.has("cities")) {
				JsonNode citiesNode = jsonNode.get("cities");
				City[] cities = objectMapper.treeToValue(citiesNode, City[].class);

			} else {
				System.out.println("JSON dosyasında 'cities' düğümü bulunamadı.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
