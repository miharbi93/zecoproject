package com.example.online_backend;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title = "Stude",description = "dafa"))
public class OnlineBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBackendApplication.class, args);
	}

}
