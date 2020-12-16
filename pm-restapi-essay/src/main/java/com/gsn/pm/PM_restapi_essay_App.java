package com.gsn.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class PM_restapi_essay_App {
    public static void main(String[] args) {
        SpringApplication.run(PM_restapi_essay_App.class, args);
    }
}