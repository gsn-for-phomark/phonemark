package com.gsn.pm.service;


import com.google.gson.Gson;
import com.gsn.pm.client.EssayClient;
import com.gsn.pm.entity.EssayType;
import com.gsn.pm.entity.Essayinfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//Hystrix服务层:  调用 PiclibClient,实现断路器功能
@Service
public class EssayRestService {


    @Autowired
    private EssayClient essayClient;

    @HystrixCommand(fallbackMethod = "findEssayInfoFallback")
    public String findEssayInfo() {
        return essayClient.doFindByEssayInfo();
    }

    private String findEssayInfoFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findEssayInfo异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "findEssayHeatFallback")
    public String findEssayHeat() {
        return essayClient.doFindByEssayHeat();
    }

    private String findEssayHeatFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findEssayHeat异步服务异常");
        return new  Gson().toJson(map);
    }

    @HystrixCommand(fallbackMethod = "findEssayTimeFallback")
    public String findEssayTime() {
        return essayClient.doFindByEssayTime();
    }

    private String findEssayTimeFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findEssayTime异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "findPhotrixFallback")
    public String findPhotrix() {
        return essayClient.doFindPhotrix();
    }

    private String findPhotrixFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findPhotrix异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "findEssayandCommentFallback")
    public String findEssayandComment() {
        return essayClient.doFindEssayandComment();
    }

    private String findEssayandCommentFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findEssayandComment异步服务异常");
        return new  Gson().toJson(map);
    }



    @HystrixCommand(fallbackMethod = "findEssayandCommentByEtypeFallback")
    public String findEssayandCommentByEtype(Integer tno) {
        return essayClient.doFindEssayandCommentByEtype(tno);
    }

    private String findEssayandCommentByEtypeFallback(Integer tno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findEssayandCommentByEtype异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "showEssayFallback")
    public String showEssay(Integer eno) {
        return essayClient.doShowEssay(eno);
    }

    private String showEssayFallback(Integer eno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","showEssay异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "addEssayFallback")
    public String addEssay(Essayinfo t) {
        return essayClient.doAddEssay(t);
    }

    private String addEssayFallback(Essayinfo t){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","addEssay异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "essaytypeTotalFallback")
    public String essaytypeTotal( ) {
        return essayClient.doEssaytypeTotal();
    }

    private String essaytypeTotalFallback(){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","essaytypeTotal异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "findByTnoEssayFallback")
    public String findByTnoEssay(Integer tno) {
        return essayClient.doFindByTnoEssay(tno);
    }

    private String findByTnoEssayFallback(Integer tno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findByTnoEssay异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "findEssayListFallback")
    public String findEssayList(Integer mno) {
        return essayClient.doFindEssayList(mno);
    }

    private String findEssayListFallback(Integer mno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","findEssayList异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "doDeleteFallback")
    public String doDelete(Integer eno) {
        return essayClient.doDelete(eno);
    }

    private String doDeleteFallback(Integer eno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","doDelete异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "favoriteTypeFallback")
    public String favoriteType(Integer mno) {
        return essayClient.doFavoriteType(mno);
    }

    private String favoriteTypeFallback(Integer mno){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","favoriteType异步服务异常");
        return new  Gson().toJson(map);
    }


    @HystrixCommand(fallbackMethod = "addTypeFallback")
    public String addType(EssayType t) {
        return essayClient.doAddType(t);
    }

    private String addTypeFallback(EssayType t){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","addType异步服务异常");
        return new  Gson().toJson(map);
    }



    @HystrixCommand(fallbackMethod = "FileUploadFallback")
    public String FileUpload(HttpServletRequest request) {
        return essayClient.FileUpload(request);
    }

    private String FileUploadFallback(HttpServletRequest request){
        Map map=new HashMap();
        map.put("code","-1");
        map.put("msg","FileUpload异步服务异常");
        return new  Gson().toJson(map);
    }
}
