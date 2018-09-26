package com.example.eureka;

import com.example.eureka.listeners.events.DemoEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class EurekaCenter {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EurekaCenter.class, args);
		applicationContext.publishEvent(new DemoEvent(1,"+++事件内容+++"));
	}
}
