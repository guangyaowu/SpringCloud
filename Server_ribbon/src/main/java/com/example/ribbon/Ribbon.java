package com.example.ribbon;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
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


	@Bean//HystrixDashboard监控需要的servlet，没有自动注册，需要手动注入
	ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(streamServlet);
		servletRegistrationBean.setLoadOnStartup(1);
		servletRegistrationBean.addUrlMappings("/hystrix.stream");
		servletRegistrationBean.setName("HystrixMetricsStreamServlet");
		return servletRegistrationBean;
	}

}
