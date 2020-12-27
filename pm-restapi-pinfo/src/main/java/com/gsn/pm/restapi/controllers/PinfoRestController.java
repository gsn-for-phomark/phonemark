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
 *      /pinfo/fans     关注与粉丝查询
 *      /pinfo/getEssayNums     计算用户文章
 *      /pinfo/finduser    查找用户
 *      /pinfo/doElist  显示自己发表的文章
 *      /doFavorite     查看个人常用专题
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



}
