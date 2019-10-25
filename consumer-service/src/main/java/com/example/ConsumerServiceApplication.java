package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //语序当前的项目使用feign声明的方式访问服务
@EnableDiscoveryClient
//这是注释
public class ConsumerServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(ConsumerServiceApplication.class,args);
    }
}
