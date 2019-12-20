package com.example.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.example"})
public class SprinBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinBootTestApplication.class, args);
	}

}
