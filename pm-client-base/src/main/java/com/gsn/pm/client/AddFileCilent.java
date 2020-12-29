package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",contextId = "file",
        configuration = FeignClientConfig.class)// 配置要按自定义的类FeignClientConfig
public interface AddFileCilent {

    @RequestMapping(method = RequestMethod.POST,value = "/gsn-api/essay-upload/upload/image",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String FileUpload(@RequestBody MultipartHttpServletRequest request);

}
