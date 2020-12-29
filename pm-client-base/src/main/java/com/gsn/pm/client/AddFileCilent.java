package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",contextId = "file",
        configuration = FeignClientConfig.class)// 配置要按自定义的类FeignClientConfig
public interface AddFileCilent {

    @RequestMapping(method = RequestMethod.POST,value = "/gsn-api/essay-upload/upload/image",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE}

    )
    String FileUpload(@RequestBody(required = false) MultipartFile file
            ,@RequestParam("ename") String ename,@RequestParam("edser") String edser,@RequestParam("tname")
                              String tname,@RequestParam("mno") Integer mno);

}
