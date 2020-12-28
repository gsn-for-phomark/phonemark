package com.gsn.pm.restapi.controllers;

import com.google.gson.Gson;
import com.gsn.pm.entity.Memberinfo;
import com.gsn.pm.service.PinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * pinfo的基本业务
 * 包含：
 *      /pinfo/phone    绑定手机号
 *      /pinfo/email    绑定邮箱
 *      /pinfo/pwd      修改密码
 *      /pinfo/doCon    密码验证
 *      /pinfo/finduser    查找用户
 */
@RestController
@RequestMapping("/pinfo")
public class PinfoRestController {
    
    private static Logger logger= LoggerFactory.getLogger(PinfoRestController.class);
    
    @Autowired
    private PinfoService pinfoService;

    /**
     * 绑定手机号
     */
    @RequestMapping(value = "/phone",method = RequestMethod.GET)
    public CompletableFuture<String> updateTel(Integer mno,String tel){
        return CompletableFuture.supplyAsync(()->{
            Memberinfo memberinfo=new Memberinfo();
            memberinfo.setMno(mno);
            memberinfo.setTel(tel);
            Map<String,Object> map=new HashMap<>();
            int data=pinfoService.updateTel(memberinfo);
            if (data==1){
                logger.info("绑定手机号码成功  1");
                map.put("code",1);
                map.put("msg","修改手机号成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("绑定手机号码失败  0");
                map.put("code",0);
                map.put("msg","修改手机号失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });
    }
    /**
     * 绑定邮箱
     */
    @RequestMapping(value = "/email",method = RequestMethod.GET)
    public CompletableFuture<String> updateEmail(Integer mno,String email){
        return CompletableFuture.supplyAsync(()->{
            Memberinfo memberinfo=new Memberinfo();
            memberinfo.setMno(mno);
            memberinfo.setEmail(email);
            Map<String,Object> map=new HashMap<>();
            int data=pinfoService.updateEmail(memberinfo);
            if (data==1){
                logger.info("绑定邮箱成功  1");
                map.put("code",1);
                map.put("msg","修改邮箱成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("绑定邮箱失败  0");
                map.put("code",0);
                map.put("msg","修改邮箱失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });
    }
    /**
     * 修改密码
     */
    @RequestMapping(value = "/pwd ",method = RequestMethod.GET)
    public CompletableFuture<String> updatePwd(Integer mno,String pwd){
        return CompletableFuture.supplyAsync(()->{
            Memberinfo memberinfo=new Memberinfo();
            memberinfo.setMno(mno);
            memberinfo.setPwd(pwd);
            Map<String,Object> map=new HashMap<>();
            int data=pinfoService.updatePwd(memberinfo);
            if (data==1){
                logger.info("绑定密码成功  1");
                map.put("code",1);
                map.put("msg","修改密码成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("绑定密码失败  0");
                map.put("code",0);
                map.put("msg","修改密码失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });
    }

    /**
     * 查找用户
     */
    @RequestMapping(value = "/finduser",method = RequestMethod.GET)
    public CompletableFuture<String> findUser(Integer mno,String Nickname,String pwd,String tel,Integer status){
        return CompletableFuture.supplyAsync(()->{
            Memberinfo memberinfo=new Memberinfo();
            memberinfo.setMno(mno);
            memberinfo.setNickName(Nickname);
            memberinfo.setPwd(pwd);
            memberinfo.setTel(tel);
            memberinfo.setStatus(status);
            Map<String,Object> map=new HashMap<>();
            Map<String,Object> data=pinfoService.findIndex(memberinfo);
            if (data!=null){
                logger.info("查找用户成功  1");
                map.put("code",1);
                map.put("msg","查找用户成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("查找用户失败  0");
                map.put("code",0);
                map.put("msg","查找失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });
    }


    /**
     * 密码验证
     */
    @RequestMapping(value = "/doCon",method = RequestMethod.GET)
    public CompletableFuture<String> doCon(Integer mno,String Nickname,String pwd){
        return CompletableFuture.supplyAsync(()->{
            Memberinfo memberinfo=new Memberinfo();
            memberinfo.setMno(mno);
            memberinfo.setNickName(Nickname);
            memberinfo.setPwd(pwd);
            Map<String,Object> map=new HashMap<>();
            Map<String,Object> data=pinfoService.doConn(memberinfo);
            if (data!=null){
                logger.info("密码验证成功  1");
                map.put("code",1);
                map.put("msg","密码验证成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("密码验证失败  0");
                map.put("code",0);
                map.put("msg","密码验证失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });
    }


}
