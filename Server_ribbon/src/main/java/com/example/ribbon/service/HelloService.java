package com.example.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")//当接收不到server-1的服务返回结果时，将返回hiError的返回值
    public String hiService(String name) {
        return restTemplate.getForObject("http://server-1/hi?name=" + name,String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error !!!!";
    }

}
