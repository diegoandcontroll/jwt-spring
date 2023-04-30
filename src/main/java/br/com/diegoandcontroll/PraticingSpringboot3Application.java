package br.com.diegoandcontroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Jwt auth example", version = "1.0", description = "Simple example jwt auth"))
public class PraticingSpringboot3Application {

	public static void main(String[] args) {
		SpringApplication.run(PraticingSpringboot3Application.class, args);
	}

}
