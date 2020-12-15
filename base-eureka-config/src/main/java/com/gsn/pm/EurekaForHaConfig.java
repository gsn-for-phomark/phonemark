package com.gsn.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaForHaConfig {
    public static void main(String[] args) {
        SpringApplication.run(EurekaForHaConfig.class, args);
    }
}