package com.example.server_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Server_2 {

	public static void main(String[] args) {
		SpringApplication.run(Server_2.class, args);
	}
}
