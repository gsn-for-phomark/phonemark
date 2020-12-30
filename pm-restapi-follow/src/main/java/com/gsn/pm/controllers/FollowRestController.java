package com.gsn.pm.controllers;

import com.google.gson.Gson;
import com.gsn.pm.entity.FollowList;
import com.gsn.pm.entity.Followinfo;
import com.gsn.pm.service.FollowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/follow")
public class FollowRestController {
    private static Logger logger = LoggerFactory.getLogger(FollowRestController.class);
    @Autowired
    private FollowService followService;

    /**
     * 文章用户的关注关系
     * @param mno,bno
     * @return
     */
    @RequestMapping(value = "/checkEssayUser",method = RequestMethod.GET)
    public CompletableFuture<String> docheckEssayUser(Integer mno,Integer bno)throws Exception{
        return  CompletableFuture.supplyAsync(() -> {
            Map<String, Object> map = new HashMap<>();
            Followinfo followinfo =new Followinfo();
            followinfo.setMno(mno);
            followinfo.setBno(bno);
            Map<String, Object> data = followService.checkEssayUser(followinfo);
            if(data!=null){
                logger.info("文章用户的关注关系查找成功   1");
                map.put("code", 1);
                map.put("msg","文章用户的关注关系查找成功");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("文章用户的关注关系查找失败   0");
                map.put("code", 0);
                map.put("msg","文章用户的关注关系查找失败");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });

    }

    /**
     * 判断对方是否为登录用户粉丝
     * @param mno,bno
     * @return
     */
    @RequestMapping(value = "/checkFollows",method = RequestMethod.GET)
    public CompletableFuture<String> docheckFollows(Integer mno,Integer bno)throws Exception{
        return  CompletableFuture.supplyAsync(() -> {
            Map<String, Object> map = new HashMap<>();
            Followinfo followinfo1 =new Followinfo();
            followinfo1.setMno(mno);
            followinfo1.setBno(bno);
            Map<String, Object> data = followService.checkFollows(followinfo1);
            if(data!=null){
                logger.info("判断对方是否为登录用户粉丝   1");
                map.put("code", 1);
                map.put("msg","判断对方是否为登录用户粉丝");
                map.put("data",data);
                return new Gson().toJson(map);
            }else{
                logger.info("判断对方是否为登录用户粉丝   0");
                map.put("code", 0);
                map.put("msg","判断对方是否为登录用户粉丝");
                map.put("data",data);
                return new Gson().toJson(map);
            }
        });
    }


    /**
     * 添加关注
     * @param mno,bno
     * insert into followinfo values(null,?,?,0,1)
     */
    @RequestMapping(value = "/addFollow",method = RequestMethod.GET)
    public CompletableFuture<String> doaddFollow(Integer mno,Integer bno)throws Exception{

       return   CompletableFuture.supplyAsync(() -> {
           Followinfo followinfo =new Followinfo();
           followinfo.setMno(mno);
           followinfo.setBno(bno);
           Map<String, Object> map = new HashMap<>();
           int i= followService.addFollow(followinfo);
           if(i==1){
               logger.info("添加关注成功   1");
               map.put("code", 1);
               map.put("msg","添加关注成功");
               map.put("data", followinfo);
               return new Gson().toJson(map);
           }else{
               logger.info("添加关注失败   0");
               map.put("code", 0);
               map.put("msg","添加关注失败");
               map.put("data", followinfo);
               return new Gson().toJson(map);
           }
       });
    }

    /**
     * 关注数据的修改
     * @param
     * @return
     */
    @RequestMapping(value = "/add02",method = RequestMethod.GET)
    public CompletableFuture<String> doadd02(Integer mno,Integer bno)throws Exception{
        return   CompletableFuture.supplyAsync(() -> {
            Followinfo followinfo =new Followinfo();
            followinfo.setMno(mno);
            followinfo.setBno(bno);
            System.out.println("添加关注：=="+followinfo.toString());
            Map<String, Object> map = new HashMap<>();
            int i= followService.add02(followinfo);
            if(i==1){
                logger.info("关注数据的修改成功   1");
                map.put("code", 1);
                map.put("msg","添加关注成功");
                map.put("data", followinfo);
                return new Gson().toJson(map);
            }else{
                logger.info("关注数据的修改失败   0");
                map.put("code", 0);
                map.put("msg","添加关注失败");
                map.put("data", followinfo);
                return new Gson().toJson(map);
            }
        });
    }

    /**
     * 已关注的取关
     * @param mno,bno,status
     * @return
     */
    @RequestMapping(value = "/delete01",method = RequestMethod.GET)
    public CompletableFuture<String> dodelete01(Integer mno,Integer bno,Integer status)throws Exception{
        return   CompletableFuture.supplyAsync(() -> {
            Followinfo followinfo =new Followinfo();
            followinfo.setMno(mno);
            followinfo.setBno(bno);
            followinfo.setStatus(status);
            System.out.println(followinfo.toString());
            Map<String, Object> map = new HashMap<>();
            int i= followService.delete01(followinfo);
            if(i==1){
                logger.info("已关注的取关成功   1");
                map.put("code", 1);
                map.put("msg","已关注的取关成功");
                map.put("data", followinfo);
                return new Gson().toJson(map);
            }else{
                logger.info("已关注的取关失败   0");
                map.put("code", 0);
                map.put("msg","已关注的取关失败");
                map.put("data", followinfo);
                return new Gson().toJson(map);
            }
        });
    }
    /**
     * 互相关注的取关
     * @param mno,bno,status
     * @return
     */
    @RequestMapping(value = "/delete02",method = RequestMethod.GET)
    public CompletableFuture<String> dodelete02(Integer mno,Integer bno,Integer status)throws Exception{
        return   CompletableFuture.supplyAsync(() -> {
            Followinfo followinfo =new Followinfo();
            followinfo.setMno(mno);
            followinfo.setBno(bno);
            followinfo.setMno(mno);
            followinfo.setBno(bno);
            followinfo.setStatus(status);
            followinfo.setMno(mno);
            followinfo.setBno(bno);
            followinfo.setStatus(status);
            Map<String, Object> map = new HashMap<>();
            int i= followService.delete02(followinfo);
            if(i==1){
                logger.info("互相关注的取关成功   1");
                map.put("code", 1);
                map.put("msg","互相关注的取关成功");
                map.put("data", followinfo);
                return new Gson().toJson(map);
            }else{
                logger.info("互相关注的取关失败   0");
                map.put("code", 0);
                map.put("msg","互相关注的取关失败");
                map.put("data", followinfo);
                return new Gson().toJson(map);
            }
        });
    }



    /**
     * 关注列表
     * @param mno,bno
     * @return
     */
    @RequestMapping(value = "/findFollow",method = RequestMethod.GET)
    public CompletableFuture<String> dofindFollow(Integer mno)throws Exception{
        return   CompletableFuture.supplyAsync(() -> {
            //Followinfo followinfo =new Followinfo();
            FollowList followList =new FollowList();
            //followinfo.setMno(mno);
            followList.setFollno(mno);
            Map<String, Object> data = followService.findFollow(followList,mno);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", data);
            map.put("msg","显示关注列表");
            return new Gson().toJson(map);
        });

    }


    /**
     * 粉丝列表
     * @param mno
     * @return
     */
    @RequestMapping(value = "/findBeFollowed",method = RequestMethod.GET)
    public CompletableFuture<String> dofindBeFollowed(Integer mno)throws Exception{
        return   CompletableFuture.supplyAsync(() -> {
            Followinfo followinfo =new Followinfo();
            FollowList followList =new FollowList();
            followinfo.setMno(mno);
            followList.setFansno(mno);
            Map<String, Object> data = followService.findBeFollowed(followList,mno);
            //协议
            Map<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("data", data);
            map.put("msg","显示粉丝列表");
            return new Gson().toJson(map);
        });

    }



}
