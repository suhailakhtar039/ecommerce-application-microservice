package com.ecommerce.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.TimeZone;

@EnableMongoAuditing
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner checkDb(MongoTemplate mongoTemplate) {
		return args -> System.out.println("MongoDB DB NAME: " + mongoTemplate.getDb().getName());
	}

}
