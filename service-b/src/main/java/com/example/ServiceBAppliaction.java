package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient //表明自己是个eureka客户端
@RestController
public class ServiceBAppliaction {
    public static void main(String[] args) {

        SpringApplication.run(ServiceBAppliaction.class,args);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello spring-cloud";
    }
}
