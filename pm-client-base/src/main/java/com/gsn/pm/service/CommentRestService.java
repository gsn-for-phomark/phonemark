package com.gsn.pm.service;


import com.google.gson.Gson;
import com.gsn.pm.client.BaseClient;
import com.gsn.pm.client.CommentClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//Hystrix服务层:  调用  CommentClient,实现断路器功能
@Service
public class CommentRestService {
    @Autowired
    private CommentClient commentClient;


    @HystrixCommand(fallbackMethod = "doAddFallback")
    public String doAdd(Integer eno,String cdesr,Integer mno){
        return commentClient.doAdd(eno, cdesr, mno);
    };

    private String doAddFallback(Integer eno,String cdesr,Integer mno) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,发表评论失败");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "doAdd2and3Fallback")
    public String  doAdd2and3(Integer eno,String cdesr,Integer mno,Integer flag,String spare1,String spare2){
        return commentClient.doAdd2and3(eno, cdesr, mno, flag, spare1, spare2);
    };

    private String doAdd2and3Fallback(Integer eno,String cdesr,Integer mno,Integer flag,String spare1,String spare2) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,发表评论失败");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "countCombackFallback")
    public String countCom(Integer eno){
        return commentClient.countCom(eno);
    };

    private String countCombackFallback(Integer eno) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,查询评论失败");
        return new Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "showCombackFallback")
    public String showCom(Integer eno){
        return commentClient.showCom(eno);
    };

    private String showCombackFallback(Integer eno) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,查询评论失败");
        return new Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "doHeatbackFallback")
    public String doHeat(Integer eno,Integer cno,Integer mno){
        return commentClient.doHeat(eno, cno, mno);
    };

    private String doHeatbackFallback(Integer eno,Integer cno,Integer mno) {
        Map map = new HashMap();
        map.put("code", "-4");
        map.put("msg", "服务异常,点赞失败");
        return new Gson().toJson(map);
    }

}
