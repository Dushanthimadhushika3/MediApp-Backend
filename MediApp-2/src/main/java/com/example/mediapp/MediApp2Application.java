package com.example.mediapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MediApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(MediApp2Application.class, args);
	}

}
