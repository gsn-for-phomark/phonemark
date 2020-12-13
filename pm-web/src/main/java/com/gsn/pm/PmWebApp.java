package com.gsn.pm;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
@EnableCircuitBreaker  //启用断路器
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.gsn.pm.client")
public class PmWebApp {
    public static void main(String[] args) {
        SpringApplication.run(PmWebApp.class,args);
    }
}
