package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import com.gsn.pm.domain.Token;
import com.gsn.pm.entity.Memberinfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY", contextId = "base",
        configuration = FeignClientConfig.class
)// 配置要按自定义的类FeignClientConfig
public interface BaseClient {

    @RequestMapping(method = RequestMethod.POST, value = "/gsn-api/base-proxy/base/Login",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String Login(@RequestBody Memberinfo memberinfo);

    @RequestMapping(method = RequestMethod.POST, value = "/gsn-api/base-proxy/base/register",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String register(@RequestBody Memberinfo memberinfo);

    @RequestMapping(method = RequestMethod.POST, value = "/gsn-api/base-proxy/base/check",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String check(@RequestBody Token token);

}
