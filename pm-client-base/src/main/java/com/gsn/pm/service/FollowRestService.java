package com.gsn.pm.service;

import com.google.gson.Gson;
import com.gsn.pm.client.FollowClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//Hystrix服务层:  调用 PiclibClient,实现断路器功能
@Service
public class FollowRestService {
    @Autowired
    private FollowClient followClient;

    @HystrixCommand(fallbackMethod = "checkEssayUserFallback")
    public String checkEssayUser(Integer mno,Integer bno) {
        return followClient.docheckEssayUser(mno, bno);
    }
    private String checkEssayUserFallback(Integer mno,Integer bno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","checkEssayUser异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "checkFollowsFallback")
    public String checkFollows(Integer mno,Integer bno) {
        return followClient.docheckFollows(mno, bno);
    }
    private String checkFollowsFallback(Integer mno,Integer bno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","checkFollows异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "addFollowFallback")
    public String addFollow(Integer mno,Integer bno) {
        return followClient.doaddFollow(mno, bno);
    }
    private String addFollowFallback(Integer mno,Integer bno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","addFollow异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "add02Fallback")
    public String add02(Integer mno,Integer bno) {
        return followClient.doadd02(mno, bno);
    }
    private String add02Fallback(Integer mno,Integer bno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","add02异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "delete01Fallback")
    public String delete01(Integer mno,Integer bno,Integer status) {
        return followClient.dodelete01(mno, bno, status);
    }
    private String delete01Fallback(Integer mno,Integer bno,Integer status){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","delete01异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "delete02Fallback")
    public String delete02(Integer mno,Integer bno,Integer status) {
        return followClient.dodelete02(mno, bno, status);
    }
    private String delete02Fallback(Integer mno,Integer bno,Integer status){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","delete02异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "findFollowFallback")
    public String findFollow(Integer mno) {
        return followClient.dofindFollow(mno);
    }
    private String findFollowFallback(Integer mno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findFollow异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "findBeFollowedFallback")
    public String findBeFollowed(Integer mno) {
        return followClient.dofindBeFollowed(mno);
    }
    private String findBeFollowedFallback(Integer mno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findBeFollowed异步服务异常");
        return new Gson().toJson(map);
    }


}
