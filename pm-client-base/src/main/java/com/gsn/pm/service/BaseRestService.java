package com.gsn.pm.service;

import com.google.gson.Gson;
import com.gsn.pm.client.BaseClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//Hystrix服务层:  调用 BaseClient,实现断路器功能
@Service
public class BaseRestService {
    @Autowired
    private BaseClient baseClient;

    @HystrixCommand(fallbackMethod = "LoginFallback")
    public String Login(String uname, String upass){
        return baseClient.Login(uname, upass);
    };

    private String LoginFallback(String uname, String upass) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,登录失败");
        return new Gson().toJson(map);
    }




    @HystrixCommand(fallbackMethod = "registerFallback")
    public String register(HttpServletRequest request){
        return baseClient.register(request);
    };

    private String registerFallback(HttpServletRequest request) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,注册失败");
        return new Gson().toJson(map);
    }



    @HystrixCommand(fallbackMethod = "checkFallback")
    public String check(HttpServletRequest request){
        return baseClient.check(request);
    };

    private String checkFallback(HttpServletRequest request) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,检查登录失败");
        return new Gson().toJson(map);
    }
}
