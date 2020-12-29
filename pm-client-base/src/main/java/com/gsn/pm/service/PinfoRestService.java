package com.gsn.pm.service;

import com.google.gson.Gson;
import com.gsn.pm.client.PinfoClient;
import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.entity.Memberinfo;
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
    public String updateTel(Integer mno ,String tel){
        return pinfoClient.doUpdateTel(mno, tel);
    }

    private String updateTelFallback(Integer mno ,String tel){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","updateTel异步服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "updateEmailFallback")
    public String updateEmail(Integer mno,String email){
        return pinfoClient.doUpdateEmail(mno, email);
    }

    private String updateEmailFallback(Integer mno,String email){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","updateEmail服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "updatePwdFallback")
    public String updatePwd(Integer mno,String pwd){
        return pinfoClient.doUpdatePwd(mno, pwd);
    }

    private String updatePwdFallback(Integer mno,String pwd){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","UpdatePwd服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "FindUserFallback")
    public String findUser(Integer mno){
        return pinfoClient.doFindUser(mno);
    }

    private String FindUserFallback(Integer mn){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","FindUser服务异常");
        return new Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "doConFallback")
    public String doCon(Integer mno,String nickName,String pwd,String tel,Integer status){
        return pinfoClient.doCon(mno, nickName, pwd, tel, status);
    }

    private String doConFallback(Integer mno,String nickName,String pwd,String tel,Integer status){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","doCon服务异常");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "dogetEssayNumsFallback")
    public String dogetEssayNums(Integer mno){
        return pinfoClient.dogetEssayNums(mno);
    }

    private String dogetEssayNumsFallback(Integer mno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","dogetEssayNums服务异常");
        return new Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "dogetFansFallback")
    public String dogetFans(Integer mno,Integer bno){
        return pinfoClient.dogetFans(mno, bno);
    }

    private String dogetFansFallback(Integer mno,Integer bno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","dogetFansFallback服务异常");
        return new Gson().toJson(map);
    }


}
