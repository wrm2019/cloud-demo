package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceAApplication {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class,args);
    }

    //访问其他服务的http客户端
    @Bean
    @LoadBalanced //通过ribbon实现客户端的负载均衡，有服务A自己决定访问哪一个服务B
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    /*
    * 服务A作为服务消费者通过访问服务B获得的数据转交给前台
    *
    * */

    @RequestMapping("/proxyHello")
    public String proxyHello(){
        //需要通过RestTemplate对象访问服务B
       return restTemplate.getForObject("http://service-b/hello", String.class);

    }
}
