package com.vamsi.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableMongoRepositories
public class TodoApplication {
	public static void main(String[] args) {
		System.out.print("Application starting");
		SpringApplication.run(TodoApplication.class, args);
	}

}
