package com.gsn.pm.service;

import com.google.gson.Gson;
import com.gsn.pm.client.PinfoClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PinfoRestService {

    @Autowired
    private PinfoClient pinfoClient;


    @HystrixCommand(fallbackMethod = "updateTelFallback")
    public String updateTel(){
        return pinfoClient.doUpdateTel();
    }

    private String updateTelFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","updateTel异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "updateEmailFallback")
    public String updateEmail(){
        return pinfoClient.doUpdateEmail();
    }

    private String updateEmailFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","updateEmail服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "updatePwdFallback")
    public String updatePwd(){
        return pinfoClient.doUpdatePwd();
    }

    private String updatePwdFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","UpdatePwd服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "FindUserFallback")
    public String findUser(){
        return pinfoClient.doFindUser();
    }

    private String FindUserFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","FindUser服务异常");
        return new Gson().toJson(map);
    }




}
