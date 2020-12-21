package com.gsn.pm.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    //加入安全配置
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("admin", "a");
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public HttpHeaders getHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        String auth = "admin:a";   //认证的原始用户名和密码
//        byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
//        String authHeader = "Basic " + new String(encodeAuth);
//        headers.set("Authorization", authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
//        System.err.println(headers);
//        return headers;
//    }
}

