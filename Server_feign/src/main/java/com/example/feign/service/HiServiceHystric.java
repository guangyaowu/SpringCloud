package com.example.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystric implements HiService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+ name +" !!!!!!";
    }
}
