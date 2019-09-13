package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableNeo4jRepositories(basePackages = "com.stackroute.repository")
//@ComponentScan(basePackages = {"com.stackroute"})
//@ComponentScan(basePackageClasses = BookResource.class)
public class MovieDataPopulatorService {

	public static void main(String[] args) {
		SpringApplication.run(MovieDataPopulatorService.class, args);
	}

}
