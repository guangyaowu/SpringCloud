package com.example.server_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Server_3 {

	public static void main(String[] args) {
		SpringApplication.run(Server_3.class, args);
	}
}
