package com.formation.simpleboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBootApplication.class, args);
		
		System.out.println("http://localhost:8080/sum?a=2&b=6");
	}

}
