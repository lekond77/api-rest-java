package com.leon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
@Data
public class ApiApplication{

/*	@GetMapping("/")
	String home() {
		return "Hello World!";
	}*/
	

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


}
