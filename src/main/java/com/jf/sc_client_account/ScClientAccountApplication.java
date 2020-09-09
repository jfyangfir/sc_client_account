package com.jf.sc_client_account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//-EnableDiscoveryClient :适合于Spring Boot支待的所有注册中心
//-EnableEurekaClient:只适合于Eureka注册中心
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
public class ScClientAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScClientAccountApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
            return new RestTemplate();
    }
}
