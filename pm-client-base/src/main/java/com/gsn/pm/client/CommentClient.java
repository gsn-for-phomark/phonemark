package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",contextId = "comment",
        configuration = FeignClientConfig.class
)// 配置要按自定义的类FeignClientConfig
public interface CommentClient {
    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/comment-proxy/comment/add",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doAdd(@RequestParam("eno") Integer eno, @RequestParam("cdesr") String cdesr, @RequestParam("mno") Integer mno);


    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/comment-proxy/comment/add2and3",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doAdd2and3(@RequestParam("eno") Integer eno, @RequestParam("cdesr") String cdesr, @RequestParam("mno") Integer mno,
                      @RequestParam("flag") Integer flag,@RequestParam("spare1")String spare1,@RequestParam("spare2") String spare2);


    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/comment-proxy/comment/countCom",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String countCom(@RequestParam("eno") Integer eno);

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/comment-proxy/comment/showCom",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String showCom(@RequestParam("eno") Integer eno);

    @RequestMapping(method = RequestMethod.GET, value = "/gsn-api/comment-proxy/comment/heat",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String doHeat(@RequestParam("eno") Integer eno,@RequestParam("cno")Integer cno,@RequestParam("mno")Integer mno);

}
