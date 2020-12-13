package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",
        configuration = FeignClientConfig.class
)// 配置要按自定义的类FeignClientConfig
public interface BaseClient {

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/base-proxy/base/Login"
            )
    String Login(@RequestParam("uname") String uname, @RequestParam("upass") String upass);

    @RequestMapping(method = RequestMethod.POST, value = "/gsn-api/base-proxy/base/register",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String register(@RequestBody HttpServletRequest request);

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/base-proxy/base/check",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String check(HttpServletRequest request);

}
