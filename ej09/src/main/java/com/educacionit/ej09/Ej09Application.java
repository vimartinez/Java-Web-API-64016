package com.educacionit.ej09;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class Ej09Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej09Application.class, args);
	}
	
	public OpenAPI customOpenAPI(@Value("V1") String appVersion) {
		return new OpenAPI().info(new Info().title("Java Web API - ej09 ")
				.version(appVersion)
				.description("API que consume otra API para sugerir peliculas")
				.termsOfService("http://google.com")
				.license(new License().name("Apache 2.0").url("http://google.com")));
		
	}

}
