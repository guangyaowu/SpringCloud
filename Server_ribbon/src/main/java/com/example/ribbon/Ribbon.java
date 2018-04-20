package com.example.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class Ribbon {

	public static void main(String[] args) {
		SpringApplication.run(Ribbon.class, args);
	}


	@Bean
	@LoadBalanced//@LoadBalanced注解表明这个restRemplate开启负载均衡的功能
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
