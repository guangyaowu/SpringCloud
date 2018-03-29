package com.example.producer_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Producer1Application {

	public static void main(String[] args) {
		SpringApplication.run(Producer1Application.class, args);
	}
}
