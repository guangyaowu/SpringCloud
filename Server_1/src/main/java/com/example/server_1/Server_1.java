package com.example.server_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Server_1 {

	public static void main(String[] args) {
		SpringApplication.run(Server_1.class, args);
	}
}
