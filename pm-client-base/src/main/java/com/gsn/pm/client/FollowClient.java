package com.gsn.pm.client;

import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MICROSERVICE-PROVIDER-FOLLOW",
        configuration = FeignClientConfig.class)// 配置要按自定义的类FeignClientConfig
public interface FollowClient {

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/checkEssayUser",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String docheckEssayUser(@RequestParam("mno") Integer mno,@RequestParam("bno") Integer bno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/checkFollows",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String docheckFollows(@RequestParam("mno") Integer mno,@RequestParam("bno") Integer bno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/addFollow",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doaddFollow(@RequestParam("mno") Integer mno,@RequestParam("bno") Integer bno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/add02",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doadd02(@RequestParam("mno") Integer mno,@RequestParam("bno") Integer bno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/delete01",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String dodelete01(@RequestParam("mno") Integer mno,@RequestParam("bno") Integer bno,@RequestParam("status") Integer status);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/delete02",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String dodelete02(@RequestParam("mno") Integer mno,@RequestParam("bno") Integer bno,@RequestParam("status") Integer status);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/findFollow",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String dofindFollow(@RequestParam("mno") Integer mno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/follow-proxy/follow/findBeFollowed",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String dofindBeFollowed(@RequestParam("mno") Integer mno);
}
