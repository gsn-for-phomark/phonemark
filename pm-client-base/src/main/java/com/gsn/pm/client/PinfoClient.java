package com.gsn.pm.client;


import com.gsn.pm.config.FeignClientConfig;
import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.entity.Memberinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BASE-MICROSERVICE-ZUUL-GATEWAY",contextId = "pinfo",
        configuration = FeignClientConfig.class
)// 配置要按自定义的类FeignClientConfig
public interface PinfoClient {

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/phone",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doUpdateTel(@RequestParam("mno") Integer mno,@RequestParam("tel")String tel);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/email",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doUpdateEmail(@RequestParam("mno") Integer mno,@RequestParam("email")String email);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/pwd",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doUpdatePwd(@RequestParam("mno") Integer mno,@RequestParam("pwd")String pwd);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/finduser",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doFindUser(@RequestParam("mno")Integer mno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/doCon",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String doCon(@RequestParam("mno")Integer mno,@RequestParam("nickName")String nickName,@RequestParam("pwd")String pwd,@RequestParam("tel")String tel,@RequestParam("status")Integer status);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/getEssayNums",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String dogetEssayNums(@RequestParam("mno")Integer mno);

    @RequestMapping(method = RequestMethod.GET,value = "/gsn-api/pinfo-proxy/pinfo/fans",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String dogetFans(@RequestParam("mno")Integer mno,@RequestParam("bno") Integer bno);





}
