package com.example.geodestarter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GeodeStarterApplication {

	public static void main(String[] args) {
//		SpringApplication.run(GeodeStarterApplication.class, args);
		new SpringApplicationBuilder(GeodeStarterApplication.class)
		.web(WebApplicationType.SERVLET)
		.build()
		.run(args);
	}
}
