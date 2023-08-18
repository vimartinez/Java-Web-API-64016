package com.educacionit.ej10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class Ej10Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej10Application.class, args);
	}
	
	public OpenAPI customOpenAPI(@Value("V1") String appVersion) {
		return new OpenAPI().info(new Info().title("Java Web API - ej10 ")
				.version(appVersion)
				.description("API de acceso a datos")
				.termsOfService("http://google.com")
				.license(new License().name("Apache 2.0").url("http://google.com")));
		
	}

}
