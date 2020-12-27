package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",contextId = "pinfo",
        configuration = FeignClientConfig.class
)// 配置要按自定义的类FeignClientConfig
public interface PinfoClient {

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/phone",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doUpdateTel();

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/email",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doUpdateEmail();

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/pwd",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doUpdatePwd();

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/finduser",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doFindUser();





}
