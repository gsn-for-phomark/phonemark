package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",
        configuration = FeignClientConfig.class
)// 配置要按自定义的类FeignClientConfig
public interface BaseClient {

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/base-proxy/base/Login",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String Login(HttpServletRequest request, HttpServletResponse response);

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/base-proxy/base/register",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String register(HttpServletRequest request, HttpServletResponse response);

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/base-proxy/base/check",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String check(HttpServletRequest request, HttpServletResponse response);


}
